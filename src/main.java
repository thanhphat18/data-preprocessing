import preprocess.sparse;
import utils.CSV2ARFF;

public class main {
    public static void main(String[] args) {
        try{
            System.out.println("Loading the CSV file...");
            String filePath = "src/datasets/summer-products-with-rating-and-performance_2020-08.csv";

            //Convert CSV to ARFF
            CSV2ARFF converter = new CSV2ARFF();
            converter.convertCSVToARFF(filePath, filePath.replace(".csv", ".arff"));

            //Sparse the ARFF file
            sparse sparseConverter = new sparse();
            sparseConverter.nonSparseToSparse(filePath.replace(".csv", ".arff"));

        } catch (Exception e) {
            System.out.println("Error loading the CSV file: " + e.getMessage());
        }
    }
    
}
