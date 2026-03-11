class Main {
    public static void main(String[] args) {

        // --- SETUP MOCK DATABASE ---
        DeviceRepository mockDeviceRepo = new DeviceRepository() {
            private final Map<String, Device> db = new HashMap<>();

            // Populăm baza de date inițială
            {
                db.put("SKU-111", new Device("SKU-111", "Senzor Mișcare Aqara", "Sensor", 25.50, "Zigbee 3.0"));
                db.put("SKU-222", new Device("SKU-222", "Bec Philips Hue", "Lighting", 50.00, "9W RGB"));
            }

            @Override
            public Optional<Device> findBySku(String sku) {
                return Optional.ofNullable(db.get(sku));
            }

            @Override
            public void saveAll(List<Device> devices) {
                for (Device d : devices) {
                    db.put(d.getSku(), d);
                    System.out.println("[DB-MOCK] Salvat dispozitiv: " + d);
                }
            }
        };

        PriceHistoryRepository mockHistoryRepo = histories -> {
            for (PriceHistory h : histories) {
                System.out.println("[DB-MOCK] Salvat istoric preț: " + h);
            }
        };

        // --- INSTANȚIERE COMPONENTĂ ---
        DataBaseManager dataBaseManager = new DataBaseManager(mockDeviceRepo, mockHistoryRepo);

        // --- SIMULARE DATE EXTERNE ---
        List<ExternalDeviceDto> incomingData = Arrays.asList(
                new ExternalDeviceDto("SKU-222", "Bec Philips Hue", "Lighting", 45.00, "9W RGB"), // Update
                new ExternalDeviceDto("SKU-333", "Yale Smart Lock", "Security", 150.00, "Wi-Fi"), // Insert
                new ExternalDeviceDto("SKU-444", "Cameră Video Nest", "Security", -10.00, "1080p"), // Eroare
                new ExternalDeviceDto("SKU-111", "Senzor Mișcare Aqara", "Sensor", 25.50, "Zigbee 3.0") // Fără modificări
        );

        // --- EXECUTARE TEST ---
        System.out.println("\n--- ÎNCEPERE PROCESARE ---");
        SyncReport finalReport = dataBaseManager.syncDeviceData(incomingData);

        // --- AFIȘARE REZULTATE ---
        finalReport.printReport();
    }
}

//Prompturi folosite:
//*Am acest proiect pentru care vreau sa creez o clasa care sa aiba cel putin o metoda mai complexa(care sa nu fie seter sau getter).
// Ce promt sa iti dau astfel incat raspunsul furnizat sa fie cel optim?
//Iată promptul final și optimizat pe care mi-l poți oferi, bazat exact pe diagrama ta:
//
//„Acționează ca un Senior Backend Developer.
// Pentru aplicația 'Smart House Builder', implementează clasa DatabaseUpdateComponent
// în limbajul [Alege: Java / C# / Python / TypeScript] folosind ORM-ul [Alege: Hibernate / Entity Framework / Prisma / SQLAlchemy].
//
//Avantaje: Ofera un rezultat rapid
//Dezavantaje: Toate clasele au fost puse impreuna si au trebuit separate 
//
// *//