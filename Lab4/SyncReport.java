class SyncReport {
    private int insertedCount = 0;
    private int updatedCount = 0;
    private final List<String> errors = new ArrayList<>();

    public void incrementInserted() { insertedCount++; }
    public void incrementUpdated() { updatedCount++; }
    public void addError(String error) { errors.add(error); }

    public void printReport() {
        System.out.println("\n=== RAPORT ACTUALIZARE BAZĂ DE DATE ===");
        System.out.println("Dispozitive Noi (Inserate): " + insertedCount);
        System.out.println("Dispozitive Actualizate: " + updatedCount);
        System.out.println("Erori întâmpinate: " + errors.size());
        errors.forEach(e -> System.out.println(" [!] Eroare: " + e));
        System.out.println("=======================================\n");
    }
}