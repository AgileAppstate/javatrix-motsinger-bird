package javatrix;
public class Matrix {
    private double[][] matrix;
    private int length;
    private int width;
  
    /**
     * Constructor
     *
     * Construct an m-by-n matrix of zeros.
     * Parameters:
     *   m - Number of rows.
     *   n - Number of columns.
    **/
    public Matrix(int m, int n) {
        length = m;
        width = n;
        matrix = new double[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Constructor
     *
     * Construct an m-by-n constant matrix.
     * @param m - Number of rows.
     * @param n - Number of columns.
     * @param s - Fill the matrix with this scalar value.
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
     * Constructor
     *
     * Construct a matrix from a 2D array.
     * @param A - Two-dimensional array of doubles.
     * @throws IllegalArgumentException - All rows must have the same length
    **/
    public Matrix(double[][] A) {
        int len =  A[0].length;
        for (int k = 1; k < A.length; k++) {
            if (A[k].length != len)
                throw new java.lang.IllegalArgumentException("All rows must have the same length");
        }
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
     * Construct a matrix quickly without checking arguments.
     * @param A - Two-dimensional array of doubles.
     * @param m - Number of rows.
     * @param n - Number of columns.
    **/
    public Matrix(double[][] A, int m, int n) {
        length = m;
        width = n;
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
     * Construct a matrix from a one-dimensional packed array.
     * @param vals - One-dimensional array of doubles, packed by columns (ala Fortran).
     * @param m - Number of rows.
     * @throws java.lang.IllegalArgumentException - Array length must be a multiple of m.
    **/
    public Matrix(double[] vals, int m) {
        if (vals.length % m != 0)
            throw new java.lang.IllegalArgumentException("Array length must be a multiple of m.");
        length = vals.length / m;
        width = m;
        matrix = new double[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = vals[(i*m)+j];
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
     * minus method. Subtracts by a matrix B.
     * @param B - the matrix to subtract by.
     * @return C = A - B
     * @throws IllegalArguementException - Thrown when inner dimensions are not equal. 
     */
    public Matrix minus(Matrix B) {
        if (width != B.getWidth() || length != B.getLength())
	        throw new java.lang.IllegalArgumentException("Matrix inner dimensions must agree");
        double[][] arr2 = B.getMatrix();
        double[][] arr3 = new double[B.getLength()][B.getWidth()];
        for (int i = 0; i < arr2.length; ++i)
            for (int j = 0; j < arr2[0].length; ++j)
		        arr3[i][j] = matrix[i][j] - arr2[i][j];
        return new Matrix(arr3);
    }

    /** 
     * minus method. Subtracts by a matrix B.
     * @param B - the matrix to subtract by.
     * @return C = A + B
     * @throws IllegalArguementException - Thrown when inner dimensions are not equal. 
     */
    public Matrix plus(Matrix B) {
        if (width != B.getWidth() || length != B.getLength())
	        throw new java.lang.IllegalArgumentException("Matrix inner dimensions must agree");
        double[][] arr2 = B.getMatrix();
        double[][] arr3 = new double[B.getLength()][B.getWidth()];
        for (int i = 0; i < arr2.length; ++i)
            for (int j = 0; j < arr2[0].length; ++j)
		        arr3[i][j] = matrix[i][j] + arr2[i][j];
        return new Matrix(arr3);
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
