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

/*Creeaza o clasa Java care modeleaza componenta Data Fetching Component dintr-un sistem de tip Price Aggregator. Contextul arhitectural este urmatorul: Componenta Data Fetching este responsabila pentru preluarea datelor brute din surse externe. Aceste date includ: preturi ale produselor de la retaileri specificatii tehnice ale dispozitivelor din surse externe de specificatii Datele obtinute sunt trimise mai departe catre componenta Parsing Component, care va extrage informatiile relevante. Cerinte pentru implementare: Creeaza o clasa Java numita DataFetchingComponent. Clasa trebuie sa contina atribute relevante pentru procesul de colectare a datelor, de exemplu: lista de retaileri de la care se preiau preturile lista de surse externe pentru specificatii un buffer sau o colectie in care se stocheaza datele brute colectate un obiect de configurare (optional) timestamp-ul ultimei colectari Creeaza clase model simple pentru: Retailer SpecificationSource RawData In DataFetchingComponent adauga metode care reflecta responsabilitatile din diagrama: fetchPrices() contacteaza retailerii colecteaza preturi brute salveaza rezultatele in colectia de date brute fetchSpecifications() preia specificatii tehnice din sursele externe collectAllData() metoda principala care apeleaza fetchPrices() si fetchSpecifications() sendRawDataToParser() trimite datele brute catre o componenta ParsingComponent addRetailer(Retailer retailer) addSpecificationSource(SpecificationSource source) Adauga constructori, getteri si setteri unde este cazul. Foloseste principii OOP: incapsulare responsabilitate clara a clasei separarea modelelor de date Include comentarii JavaDoc pentru fiecare metoda, explicand rolul ei in arhitectura. Nu implementa apeluri reale HTTP; simuleaza colectarea datelor (ex: generare de obiecte RawData). Codul trebuie sa fie clar, modular si usor de extins pentru adaugarea unor noi surse externe. Structura finala trebuie sa contina: clasa DataFetchingComponent clasele model Retailer, SpecificationSource, RawData