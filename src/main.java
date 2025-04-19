import preprocess.DiscretizeAttribute;
import preprocess.sparse;
import utils.CSV2ARFF;

public class main {
    public static void main(String[] args) {
        try{
            System.out.println("Loading the CSV file...");
            String filePath = "src/datasets/summer-products-with-rating-and-performance_2020-08.csv";
            String filePath2 = "src/datasets/computed_insight_success_of_active_sellers.csv";

            //Convert CSV to ARFF
            CSV2ARFF converter = new CSV2ARFF();
            converter.convertCSVToARFF(filePath, filePath.replace(".csv", ".arff"));
            converter.convertCSVToARFF(filePath2, filePath2.replace(".csv", ".arff"));

            //Sparse the ARFF file
            sparse sparseConverter = new sparse();
            sparseConverter.nonSparseToSparse(filePath.replace(".csv", ".arff"));
            sparseConverter.nonSparseToSparse(filePath2.replace(".csv", ".arff"));

            //Discretize the ARFF file
            DiscretizeAttribute discretizer = new DiscretizeAttribute();
            discretizer.discretize(filePath.replace(".csv", "_sparse.arff"));
            discretizer.discretize(filePath2.replace(".csv", "_sparse.arff"));

        } catch (Exception e) {
            System.out.println("Error loading the CSV file: " + e.getMessage());
        }
    }
    
}
