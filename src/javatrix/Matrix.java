package javatrix;
public class Matrix {
    private double[][] matrix;
    private int length;
    private int width;
  
    /**
     * Constructor
     *
     * Construct a matrix from a 2D array.
     * Parameters:
     *   A - Two-dimensional array of doubles.
    **/
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

    /**
     * Constructor
     *
     * Construct an m-by-n constant matrix.
     * Parameters:
     *   m - Number of rows.
     *   n - Number of columns.
     *   s - Fill the matrix with this scalar value.
    **/
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
              
    /**
     * times method. Multiplies the matrix by a scalar product.  
     * @param s - the scalar.
    **/
    public Matrix times(double s) {
        Matrix c = new Matrix(length, width, 0);
        double[][] m = new double[length][width];
        for (int i = 0; i < length; ++i)
	        for (int j = 0; j < width; ++j)
		        m[i][j] = s * matrix[i][j];
        c.setMatrix(m);
        return c;
    }

    /**
     * times method. Multiplies the matrix by another matrix B.
     * @param B - the matrix to multiply by. Must be of form width * p.
     * @throws IllegalArguementException - Thrown when inner dimensions are not equal. 
    **/
    public Matrix times(Matrix B) {
        Matrix c = new Matrix(length, B.getWidth(), 0);
        if (width != B.getLength())
	        throw new java.lang.IllegalArgumentException("Matrix inner dimensions must agree"); 
        double[][] result = new double[length][B.getWidth()];
        double cell = 0;
	    double[][] b_matrix = B.getMatrix();
	    for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[0].length; ++j) {
	            for (int k = 0; k < B.getLength(); ++k)
		            cell += matrix[i][k] * b_matrix[k][j];
		        result[i][j] = cell;
		        cell = 0;
            }
        }
        c.setMatrix(result);
        return c;
    }
              
    /**
     * getMatrix method. Public accessor for the matrix field. 
    **/
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * setMatrix method. Public setter for the matrix field. 
    **/
    public void setMatrix(double[][] m) {
        matrix = m;
    }

    /**
     * getLength method. Public accessor for the length field.
    **/
    public int getLength() {
        return length;
    }

    /**
     * getWidth method. Public accessor for the width field. 
    **/
    public int getWidth() {
        return width;
    }

    /**
     * Print
     *
     * Print the matrix to stdout. Line the elements up
     * in columns with a Fortran-like 'Fw.d' style format.
     * 
     * Parameters:
     *   w - Column width.
     *   d - Number of digits after the decimal.
    **/
    public void print(int w, int d) {
        String form = "%-" + String.valueOf(w) + "." + String.valueOf(d) + "f ";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.format(form, matrix[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Matrix a = new Matrix(3, 10, 1.0);
        a.print(1, 2);
    }
}
