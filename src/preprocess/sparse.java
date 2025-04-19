package preprocess;

import utils.LoaderSaver;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.instance.NonSparseToSparse;

public class sparse {
    public void nonSparseToSparse(String filePath) {
        try {
            // Load the dataset
            DataSource source = new DataSource(filePath);
            Instances data = source.getDataSet();

            // Convert to sparse format
            NonSparseToSparse filter = new NonSparseToSparse();
            filter.setInputFormat(data);
            Instances sparseData = filter.useFilter(data, filter);

            // Save the sparse dataset
            LoaderSaver loader = new LoaderSaver();
            loader.datasets = sparseData;
            loader.saveDatasetAsARFF(filePath.replace(".arff", "_sparse.arff"));
            

        } catch (Exception e) {
            System.err.println("Error converting to sparse format: " + e.getMessage());
        }
    }
}
