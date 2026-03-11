public class Main {

    public static void main(String[] args) {

        DataFetchingComponent fetcher = new DataFetchingComponent();

        fetcher.addRetailer(new Retailer("eMAG", "api.emag.ro"));
        fetcher.addRetailer(new Retailer("Altex", "api.altex.ro"));

        fetcher.addSpecificationSource(new SpecificationSource("GSMArena", "gsmarena.com"));
        fetcher.addSpecificationSource(new SpecificationSource("DeviceSpecs", "devicespecs.com"));

        fetcher.collectAllData();

        ParsingComponent parser = new ParsingComponent();

        fetcher.sendRawDataToParser(parser);
    }
}