public class Matrix {
    double[][] matrix;
    int length;
    int width;

    
    // Construct a matrix from a 2D array.
    // Parameters:
    //   A - Two-dimensional array of doubles.
    public Matrix(double[][] A) {
        //TODO: throw an IllegalArgumentException if all rows in A
        //      do not have the same length
        
        length = A.length;
        width = A[0].length;
        matrix = new double[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = A[i][j];
            }
        }
    }


    // Construct an m-by-n constant matrix.
    // Parameters:
    //   m - Number of rows.
    //   n - Number of columns.
    //   s - Fill the matrix with this scalar value.
    public Matrix(int m, int n, double s) {
        length = m;
        width = n;
        matrix = new double[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = s;
            }
        }
    }
}
