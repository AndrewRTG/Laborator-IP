class PriceHistory {
    private String deviceSku;
    private double oldPrice;
    private LocalDateTime changeDate;

    public PriceHistory(String deviceSku, double oldPrice) {
        this.deviceSku = deviceSku;
        this.oldPrice = oldPrice;
        this.changeDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("PriceHistory{sku='%s', oldPrice=%.2f, date=%s}", deviceSku, oldPrice, changeDate);
    }
}