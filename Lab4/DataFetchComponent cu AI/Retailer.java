public class Retailer {

    private String name;
    private String apiEndpoint;

    public Retailer(String name, String apiEndpoint) {
        this.name = name;
        this.apiEndpoint = apiEndpoint;
    }

    public String getName() {
        return name;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }
}