package utils;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

public class CSV2ARFF {
    public void convertCSVToARFF(String csvFilePath, String arffFilePath) {
        try {
            LoaderSaver loader = new LoaderSaver();
            loader.loadCSVDataset(csvFilePath);

            // Save the data in ARFF format
            loader.saveDatasetAsARFF(arffFilePath);

            System.out.println("Conversion completed: " + arffFilePath);
        } catch (Exception e) {
            System.err.println("Error during conversion: " + e.getMessage());
        }
    }
}
