interface DeviceRepository {
    Optional<Device> findBySku(String sku);
    void saveAll(List<Device> devices);
}