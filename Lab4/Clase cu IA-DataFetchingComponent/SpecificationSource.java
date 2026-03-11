public class SpecificationSource {

    private String name;
    private String sourceUrl;

    public SpecificationSource(String name, String sourceUrl) {
        this.name = name;
        this.sourceUrl = sourceUrl;
    }

    public String getName() {
        return name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
