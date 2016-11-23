import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {

    public void listExporters(CSVParser parser, String exportOfInterest) {
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportOfInterest)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length()) {
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }

    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record : parser) {
            String rcountry = record.get("Country");
            if(rcountry.contains(country)) {
               return record.get("Country") + ": " + record.get("Exports") + " " + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) &&  exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
         for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }

    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }

    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));

        System.out.println("-------------------");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");

        System.out.println("-------------------");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));

        System.out.println("-------------------");
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
}
