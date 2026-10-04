import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WeatherSummary {
    /**
     * Reads newline-delimited temperatures from System.in and prints summary
     * statistics to System.out.
     * 
     * Example input:
     * 66.4
     * 77.1
     * 72.6
     * 
     * Example output:
     * Max: 66.4
     * Min: 77.1
     * Average: 72.03333333333333
     * 
     * @param args command line arguments (ignored)
     */
    public static void main(String[] args) {
        // Implement this method!
        // Hint: use Scanner. nextDouble() and hasNextDouble() will be helpful here!

        readTempsFromFile();
    }
    
    public static void readTempsFromFile() {
        final String TEMPS_FILE = "temps";
    
        try (Scanner scanner = new Scanner(new FileInputStream(new File(TEMPS_FILE)))) {
            double[] tempsLastThirtyDays = new double[30];
            int idx = 0;
    
            while (scanner.hasNextDouble()) {
                tempsLastThirtyDays[idx] = scanner.nextDouble();
                idx++;
            }
    
            System.out.println(Arrays.toString(tempsLastThirtyDays));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
