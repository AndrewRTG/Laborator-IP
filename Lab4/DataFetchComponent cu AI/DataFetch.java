import java.util.ArrayList;
import java.util.List;

public class DataFetchingComponent {

    private List<Retailer> retailers;
    private List<SpecificationSource> specificationSources;
    private List<RawData> rawDataBuffer;
    private long lastFetchTimestamp;

    public DataFetchingComponent() {
        retailers = new ArrayList<>();
        specificationSources =   new ArrayList<>();
        rawDataBuffer = new ArrayList<>();
    }

    /**
     * Adauga un retailer din care pot fi colectate preturi.
     */

    
    public void addRetailer(Retailer retailer) {
        retailers.add(retailer);
    }

    /**
     * Adauga o sursa externa de specificatii.
     */
    public List<RawData> fetchPricesFromRetailer(Retailer retailer) {

        List<RawData> result = new ArrayList<>();

        int attempts = 0;
        boolean success = false;

        while (!success && attempts < maxRetries) {

            attempts++;

            try {

                simulateExternalDelay();

                if (random.nextInt(10) < 2) {
                    throw new RuntimeException("Simulated network error");
                }

                int numberOfProducts = random.nextInt(3) + 1;

                for (int i = 0; i < numberOfProducts; i++) {

                    String product = "Product_" + random.nextInt(100);
                    double price = 500 + random.nextInt(2000);

                    RawData data = new RawData(
                            "PRICE",
                            retailer.getName(),
                            product,
                            "price=" + price
                    );

                    result.add(data);
                }

                success = true;

            } catch (Exception e) {

                if (attempts >= maxRetries) {
                    System.out.println("Failed to fetch prices from " + retailer.getName());
                }
            }
        }

        return result;
    }

    public List<RawData> fetchSpecificationsFromSource(SpecificationSource source) {

        List<RawData> result = new ArrayList<>();

        try {

            simulateExternalDelay();

            int devices = random.nextInt(3) + 1;

            for (int i = 0; i < devices; i++) {

                String device = "Device_" + random.nextInt(100);

                RawData data = new RawData(
                        "SPEC",
                        source.getName(),
                        device,
                        "ram=8GB;storage=128GB;battery=5000mAh"
                );

                result.add(data);
            }

        } catch (Exception e) {
            System.out.println("Error collecting specs from " + source.getName());
        }

        return result;
    }


/**
a

// promptul pus pe AI

//Creeaza o clasa Java care modeleaza componenta Data Fetching Component dintr-un sistem de tip Price Aggregator. Contextul arhitectural este urmatorul: Componenta Data Fetching este responsabila
// pentru preluarea datelor brute din surse externe. Aceste date includ: preturi ale produselor de la retaileri specificatii tehnice ale dispozitivelor din surse externe de specificatii Datele obtinute sunt trimise mai departe catre componenta Parsing Component, care va extrage informatiile
// relevante. Cerinte pentru implementare: Creeaza o clasa Java numita DataFetchingComponent. Clasa trebuie sa contina atribute relevante pentru procesul de colectare a datelor, de exemplu: lista de retaileri de la care se preiau preturile lista de surse externe pentru specificatii un buffer sau o colectie in care se stocheaza datele brute colectate un obiect de configurare (optional) timestamp-ul ultimei colectari Creeaza clase model simple pentru: Retailer SpecificationSource RawData In
// DataFetchingComponent adauga metode care reflecta responsabilitatile din diagrama: fetchPrices() contacteaza retailerii colecteaza preturi brute salveaza rezultatele in colectia de date brute fetchSpecifications() preia specificatii tehnice din sursele externe collectAllData() metoda principala care apeleaza fetchPrices() si fetchSpecifications() sendRawDataToParser() trimite datele brute catre o componenta ParsingComponent addRetailer(Retailer retailer) addSpecificationSource(SpecificationSource source) Adauga constructori, getteri si setteri unde este cazul. Foloseste principii OOP: incapsulare responsabilitate clara a clasei separarea modelelor de date Include comentarii JavaDoc pentru fiecare metoda, explicand rolul ei in arhitectura. Nu implementa apeluri reale HTTP; simuleaza colectarea datelor (ex: generare de obiecte RawData). Codul trebuie sa fie clar, modular si usor de extins pentru adaugarea unor noi surse externe. Structura finala trebuie sa contina: clasa DataFetchingComponent clasele model Retailer, SpecificationSource, RawData

//avantaj: impartite eficient in mai multe clase si cu comentarii inteligibile

//dezavantaj: a durat mult si unele clase nu au complexitate,


 // pormpt pus pe AI

 //Creeaza o clasa principala numita DataFetchingComponent. Clasa trebuie sa contina mai multe atribute, de exemplu: lista de retaileri (List<Retailer> retailers) lista de surse de specificatii (List<SpecificationSource> specificationSources)