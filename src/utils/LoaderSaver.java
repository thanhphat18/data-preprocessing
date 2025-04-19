package utils;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;

public class LoaderSaver {
    public Instances datasets;
    public void loadArffDataset(String filePath) {
        ArffLoader loader = new ArffLoader();
        try{
            // Load the ARFF file
            loader.setSource(new File(filePath));
            Instances data = loader.getDataSet();
            
            // Print the dataset information
            System.out.println("Dataset loaded: " + data.relationName());
            System.out.println("Number of instances: " + data.numInstances());
            System.out.println("Number of attributes: " + data.numAttributes());

        } catch (Exception e) {
            System.out.println("Error loading the ARFF file: " + e.getMessage());
        }
    }

    public void loadCSVDataset(String filePath) {
        // Implement CSV loading logic here
        // This is a placeholder for the actual implementation
        System.out.println("Loading CSV dataset from: " + filePath);
        CSVLoader loader = new CSVLoader();
        try {
            loader.setSource(new File(filePath));
            datasets = loader.getDataSet();
            
            // Print the dataset information
            System.out.println("Dataset loaded: " + datasets.relationName());
            System.out.println("Number of instances: " + datasets.numInstances());
            System.out.println("Number of attributes: " + datasets.numAttributes());

        } catch (Exception e) {
            System.out.println("Error loading the CSV file: " + e.getMessage());
        }
    }

    public void saveDatasetAsARFF(String filePath) {
        // Implement ARFF saving logic here
        // This is a placeholder for the actual implementation
        System.out.println("Saving dataset as ARFF to: " + filePath);
        // Add your ARFF saving logic here
        ArffSaver saver = new ArffSaver();
        try {
            saver.setInstances(datasets);
            saver.setFile(new File(filePath));
            saver.writeBatch();
            System.out.println("Dataset saved as ARFF: " + filePath);
        } catch (Exception e) {
            System.out.println("Error saving the dataset as ARFF: " + e.getMessage());
        }
    }
    
}
