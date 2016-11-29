import edu.duke.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import java.io.File;
import java.util.Set;
import java.util.HashSet;
import org.apache.commons.csv.*;

public class BabyNames {

    public void readOneFile(int year) {
        String fname = "data/yob" + year + ".txt";
        FileResource fr = new FileResource(fname);
        
        CSVParser parser = fr.getCSVParser(false);
        
        for(CSVRecord rec: parser) {
            String name = rec.get(0);
            String gender = rec.get(1);
        }
    }
    
    public void printNames() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false); // No header row
    
        for(CSVRecord rec: parser) {
            String name = rec.get(0);
            String gender = rec.get(1);
            int numOfBirth = Integer.parseInt(rec.get(2));
            if(numOfBirth <= 100)
                System.out.println("Name " + name + " Gender " + gender + " Num. of Births " + numOfBirth);
        }
    }

    public String getFilename(int year){
        return "us_babynames/us_babynames_by_year/yob"+year+".csv";
    }

    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource(getFilename(year));
        CSVParser parser = fr.getCSVParser(false);
        int mRank = 0;
        int fRank = 0;

        for(CSVRecord rec: parser){
            if(rec.get(1).equals("M")) {
                mRank += 1;
            } else {
                fRank += 1;
            }
            if(rec.get(0).equals(name) && rec.get(1).equals(gender) && gender.equals("M")) {
                return mRank;
            }
            if(rec.get(0).equals(name) && rec.get(1).equals(gender) && gender.equals("F")) {
                return fRank;
            }
        }
        return -1;
    }

    public void testGetRank() {
        System.out.printf("The rank for %s (%s) is %d \n", "Frank", "M", getRank(1971, "Frank", "M"));
    }


    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource(getFilename(year));
        CSVParser parser = fr.getCSVParser(false);
        int mRank = 0;
        int fRank = 0;
        for(CSVRecord rec: parser) {
            if(rec.get(1).equals("M")) {
                mRank += 1;
            } else {
                fRank += 1;
            }
            if(mRank == rank && rec.get(1).equals(gender) && gender.equals("M")) {
                return rec.get(0);
            }
            if(fRank == rank && rec.get(1).equals(gender) && gender.equals("F")) {
                return rec.get(0);
            }
        }
        return "NO NAME";
    }

    public void testGetName() {
        System.out.printf("The name for rank %d (%s) in %d is %s \n", 450, "M", 1980, getName(1982, 450, "M"));
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.printf("%s born in %d would be %s if born in %d \n", name, year, newName, newYear);
    }

    public void testWhatIsNameInYear() {
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }

    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource(); 
        int year = -1;
        int rank = -1;
        int highestRankYear = -1;

        for(File f : dr.selectedFiles()) {
            Matcher m = Pattern.compile(".*([0-9]{4}).*").matcher(f.getName());
            if(m.matches()) {
                year = Integer.parseInt(m.group(1));
            }
            int tempRank = getRank(year, name, gender);
            if(rank == -1) {
                rank = tempRank;
                highestRankYear = year;
            } else {
                if(rank > tempRank) {
                    rank = tempRank;
                    highestRankYear = year;
                }
            }
        }
        return highestRankYear;
    }

    public void testYearOfHighestRank() {
        System.out.printf("The year of highest rank for %s (%s) is %d \n", "Mich", "M", yearOfHighestRank("Mich", "M"));
    }

    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource(); 
        int year = -1;
        int sumRank = 0;
        int count = 0;

        for(File f : dr.selectedFiles()) {
            Matcher m = Pattern.compile(".*([0-9]{4}).*").matcher(f.getName());
            if(m.matches()) {
                year = Integer.parseInt(m.group(1));
            }

            int tempRank = getRank(year, name, gender);
            if(tempRank != -1) {
                sumRank += tempRank;
                count += 1;
            }
        }
        if(sumRank == 0) return -1.0;
        
        return (double)sumRank / count;
    }

    public void testGetAverageRank() {
        System.out.printf("The average rank of %s (%s) is %f \n", "Robert", "M", getAverageRank("Robert", "M"));
    }

    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource(getFilename(year));
        CSVParser parser = fr.getCSVParser(false);
        int rank = getRank(year, name, gender);
        int numBorn = 0; 
        
        for(CSVRecord rec: parser) {
            String rankName = rec.get(0);
            if(rec.get(1).equals(gender) && getRank(year, rankName, gender) < rank) {
                numBorn += Integer.parseInt(rec.get(2));
            }
        }
        return numBorn;
    }

    public void testGetTotalBirthsRankedHigher() {
        System.out.printf("Total Births Ranked Higher %d \n", getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }

    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        Set<String> boyNames = new HashSet<String>();
        Set<String> girlNames = new HashSet<String>();
        
        for(CSVRecord rec: fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            
            totalBirths += numBorn;
            
            if(rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boyNames.add(rec.get(0));
            } else {
                totalGirls += numBorn;
                girlNames.add(rec.get(1));
            }
            
        }
        
        System.out.println("Total Boys = " + totalBoys);
        System.out.println("Total Girls = " + totalGirls);
        System.out.println("Total Births = " + totalBirths);
        
        System.out.println("Number of Boy Names = " + boyNames.size());
        System.out.println("Number of Girl Names = " + girlNames.size());
        System.out.println("Total Number of Names = " + (boyNames.size()+girlNames.size()));
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
} 
