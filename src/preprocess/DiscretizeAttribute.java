package preprocess;

import utils.LoaderSaver;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.Filter;

public class DiscretizeAttribute {
    public void discretize(String filePath) throws Exception {
        // Implement the discretization logic here
        // This is a placeholder for the actual implementation
        System.out.println("Discretizing attributes in: " + filePath);
        // Add your discretization logic here
        //load the dataset
        DataSource source = new DataSource(filePath);
        Instances data = source.getDataSet();
        // set option
        String[] opts = new String[5];
        //choose the number of intervals
        opts[0] = "-B"; opts[1]= "4";
        //Choose the range of attrbutes on which apply the filter
        opts[2] = "-R"; opts[3] = "first-last";
        opts[4] = "-V"; 
        //apply discretization
        Discretize discretize = new Discretize();
        discretize.setOptions(opts);
        discretize.setInputFormat(data);
        Instances newData = Filter.useFilter(data, discretize);

        // Save the discretized dataset
        LoaderSaver loader = new LoaderSaver();
        loader.datasets = newData;
        loader.saveDatasetAsARFF(filePath.replace(".arff", "_discretized.arff"));
    }
}
