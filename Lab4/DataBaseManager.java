public class DataBaseManager {
    private static final Logger logger = Logger.getLogger(DataBaseManager.class.getName());

    private final DeviceRepository deviceRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    // Dependency Injection
    public DataBaseManager(DeviceRepository deviceRepository, PriceHistoryRepository priceHistoryRepository) {
        this.deviceRepository = deviceRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    /**
     * Metoda complexă: Execută logica de Upsert (Update sau Insert) + Price Tracking.
     */
    public SyncReport syncDeviceData(List<ExternalDeviceDto> fetchedDevices) {
        logger.info("Se procesează " + fetchedDevices.size() + " dispozitive externe...");

        SyncReport report = new SyncReport();
        List<Device> devicesToSave = new ArrayList<>();
        List<PriceHistory> historyToSave = new ArrayList<>();

        for (ExternalDeviceDto dto : fetchedDevices) {
            try {
                // 1. Validare
                if (dto.price() <= 0) {
                    throw new IllegalArgumentException("Prețul trebuie să fie mai mare ca 0.");
                }

                // 2. Căutăm dacă dispozitivul există deja în baza de date
                Optional<Device> existingDeviceOpt = deviceRepository.findBySku(dto.sku());

                if (existingDeviceOpt.isPresent()) {
                    Device existingDevice = existingDeviceOpt.get();

                    // 3. Logica de UPDATE: Verificăm dacă prețul sau specificațiile s-au modificat
                    if (existingDevice.getPrice() != dto.price() || !existingDevice.getSpecs().equals(dto.specs())) {

                        // Dacă prețul s-a modificat, salvăm vechiul preț în istoric
                        if (existingDevice.getPrice() != dto.price()) {
                            historyToSave.add(new PriceHistory(existingDevice.getSku(), existingDevice.getPrice()));
                        }

                        // Actualizăm datele
                        existingDevice.setPrice(dto.price());
                        existingDevice.setSpecs(dto.specs());

                        devicesToSave.add(existingDevice);
                        report.incrementUpdated();
                    }
                } else {
                    // 4. Logica de INSERT: Creăm un dispozitiv complet nou
                    Device newDevice = new Device(dto.sku(), dto.name(), dto.category(), dto.price(), dto.specs());
                    devicesToSave.add(newDevice);
                    report.incrementInserted();
                }

            } catch (Exception e) {
                // Înregistrăm eroarea, dar continuăm procesarea celorlalte dispozitive
                report.addError("Eșec la procesare SKU [" + dto.sku() + "]: " + e.getMessage());
            }
        }

        // 5. Salvarea în Batch-uri pentru performanță
        if (!historyToSave.isEmpty()) {
            priceHistoryRepository.saveAll(historyToSave);
        }
        if (!devicesToSave.isEmpty()) {
            deviceRepository.saveAll(devicesToSave);
        }

        return report;
    }
}