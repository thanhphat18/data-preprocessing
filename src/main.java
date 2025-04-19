import weka.core.Instances;
import weka.core.converters.CSVLoader;
import java.io.File;

public class main {
    public static void main(String[] args) {
        try{
            System.out.println("Loading the CSV file...");
            String filePath = "src/datasets/output.csv";
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(filePath));
            Instances data = loader.getDataSet();
        } catch (Exception e) {
            System.out.println("Error loading the CSV file: " + e.getMessage());
        }
    }
    
}
