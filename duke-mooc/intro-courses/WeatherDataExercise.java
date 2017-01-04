import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class WeatherDataExercise {
    
    public double averageTemperatureInFile(CSVParser parser) {
        double total = 0.0;
        int count = 0;
        
        for(CSVRecord currentRow : parser) {
            total += Double.parseDouble(currentRow.get("TemperatureF"));
            count += 1;
        }
        
        
        return total / count;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double total = 0.0;
        int count = 0;
        
        for(CSVRecord currentRow : parser) {
            double humidity = Double.parseDouble(currentRow.get("Humidity"));
            if(humidity >= value) {
                total += Double.parseDouble(currentRow.get("TemperatureF"));
                count += 1;
            }
            
        }
        
        
        return total / count;
    }
    
    
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord smallestSoFar = null;
        
        for(CSVRecord currentRow : parser) {
            smallestSoFar = getSmallerOfTwo(currentRow, smallestSoFar, "TemperatureF");
        }
        
        return smallestSoFar;
    }
    
    public CSVRecord coldestInManyDays() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord smallestSoFar = null;
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            smallestSoFar = getSmallerOfTwo(currentRow, smallestSoFar, "TemperatureF");
        }
        
        return smallestSoFar;
    }
    
        
    public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord smallestSoFar = null;
        File coldFile = null;
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            smallestSoFar = getSmallerOfTwo(currentRow, smallestSoFar, "TemperatureF");
            if(smallestSoFar == currentRow) {
                coldFile = f;
            }
        }
        
        System.out.println("Coldest day was in file " + coldFile.getName());
        FileResource fr = new FileResource(coldFile);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF"));
        
        return coldFile.getName();
    }
    
    public CSVRecord getSmallerOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar, String field) {
        if(smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        else {
            String currField = currentRow.get(field);
            if(currField.contains("-9999") || currField.contains("N/A")) return smallestSoFar;
            double current = Double.parseDouble(currField);
            double smaller = Double.parseDouble(smallestSoFar.get(field));
            if(current < smaller) {
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord smallestSoFar = null;
        
        for(CSVRecord currentRow : parser) {
            smallestSoFar = getSmallerOfTwo(currentRow, smallestSoFar, "Humidity");
        }
        
        return smallestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord smallestSoFar = null;
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            smallestSoFar = getSmallerOfTwo(currentRow, smallestSoFar, "Humidity");
        }
        
        return smallestSoFar;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double avgTemp = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + avgTemp);
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        double avgTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if(Double.isNaN(avgTemp))
            System.out.println("No temperatures with that humidity");
        else
        System.out.println("Average temperature in file is " + avgTemp);
    }
    
    public void testColdestInDay(){
        FileResource fr = new FileResource("data/2014/weather-2014-05-01.csv");
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("TimeEDT"));
        
    }
    
    public void testFileWithColdestTemperature(){
        String coldFile = fileWithColdestTemperature();
    }
    
    public void testColdestInManyDays(){
        CSVRecord smallest = coldestInManyDays();
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public void testLowestHumidityInManyFiles() {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        
    }
    
}
