import java.util.ArrayList;
import java.util.List;

public class DataFetchingComponent {

    private List<Retailer> retailers;
    private List<SpecificationSource> specificationSources;
    private List<RawData> rawDataBuffer;
    private long lastFetchTimestamp;

    public DataFetchingComponent() {
        retailers = new ArrayList<>();
        specificationSources = new ArrayList<>();
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
    public void addSpecificationSource(SpecificationSource source) {
        specificationSources.add(source);
    }

    /**
     * Contacteaza fiecare retailer si colecteaza preturi brute.
     * Datele sunt simulate si salvate in rawDataBuffer.
     */
    public void fetchPrices() {

        for (Retailer retailer : retailers) {

            RawData data = new RawData(
                    "price",
                    retailer.getName(),
                    "Pret simulare pentru produs"
            );

            rawDataBuffer.add(data);
        }
    }

    /**
     * Colecteaza specificatii tehnice din surse externe.
     */
    public void fetchSpecifications() {

        for (SpecificationSource source : specificationSources) {

            RawData data = new RawData(
                    "specification",
                    source.getName(),
                    "Specificatii simulate pentru dispozitiv"
            );

            rawDataBuffer.add(data);
        }
    }

    /**
     * Metoda principala care colecteaza toate datele externe.
     */
    public void collectAllData() {

        fetchPrices();
        fetchSpecifications();

        lastFetchTimestamp = System.currentTimeMillis();
    }

    /**
     * Trimite datele brute catre componenta de parsare.
     */
    public void sendRawDataToParser(ParsingComponent parser) {

        parser.parse(rawDataBuffer);

        rawDataBuffer.clear();
    }

    public long getLastFetchTimestamp() {
        return lastFetchTimestamp;
    }

    public List<RawData> getRawDataBuffer() {
        return rawDataBuffer;
    }
}

// promptul pus pe AI

//Creeaza o clasa Java care modeleaza componenta Data Fetching Component dintr-un sistem de tip Price Aggregator. Contextul arhitectural este urmatorul: Componenta Data Fetching este responsabila
// pentru preluarea datelor brute din surse externe. Aceste date includ: preturi ale produselor de la retaileri specificatii tehnice ale dispozitivelor din surse externe de specificatii Datele obtinute sunt trimise mai departe catre componenta Parsing Component, care va extrage informatiile
// relevante. Cerinte pentru implementare: Creeaza o clasa Java numita DataFetchingComponent. Clasa trebuie sa contina atribute relevante pentru procesul de colectare a datelor, de exemplu: lista de retaileri de la care se preiau preturile lista de surse externe pentru specificatii un buffer sau o colectie in care se stocheaza datele brute colectate un obiect de configurare (optional) timestamp-ul ultimei colectari Creeaza clase model simple pentru: Retailer SpecificationSource RawData In
// DataFetchingComponent adauga metode care reflecta responsabilitatile din diagrama: fetchPrices() contacteaza retailerii colecteaza preturi brute salveaza rezultatele in colectia de date brute fetchSpecifications() preia specificatii tehnice din sursele externe collectAllData() metoda principala care apeleaza fetchPrices() si fetchSpecifications() sendRawDataToParser() trimite datele brute catre o componenta ParsingComponent addRetailer(Retailer retailer) addSpecificationSource(SpecificationSource source) Adauga constructori, getteri si setteri unde este cazul. Foloseste principii OOP: incapsulare responsabilitate clara a clasei separarea modelelor de date Include comentarii JavaDoc pentru fiecare metoda, explicand rolul ei in arhitectura. Nu implementa apeluri reale HTTP; simuleaza colectarea datelor (ex: generare de obiecte RawData). Codul trebuie sa fie clar, modular si usor de extins pentru adaugarea unor noi surse externe. Structura finala trebuie sa contina: clasa DataFetchingComponent clasele model Retailer, SpecificationSource, RawData

//avantaj: impartite eficient in mai multe clase si cu comentarii inteligibile

//dezavantaj: a durat mult si unele clase nu au complexitate,