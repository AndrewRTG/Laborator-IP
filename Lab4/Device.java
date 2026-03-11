class Device {
    private String sku;
    private String name;
    private String category;
    private double price;
    private String specs;

    public Device(String sku, String name, String category, double price, String specs) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.specs = specs;
    }

    public String getSku() { return sku; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getSpecs() { return specs; }
    public void setSpecs(String specs) { this.specs = specs; }

    @Override
    public String toString() {
        return String.format("Device{sku='%s', name='%s', price=%.2f, specs='%s'}", sku, name, price, specs);
    }
}