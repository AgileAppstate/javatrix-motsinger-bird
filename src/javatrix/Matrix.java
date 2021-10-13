package javatrix;
public class Matrix {
    private double[][] matrix;
    private int length;
    private int width;
  
    /**
     * Constructor
     *
     * Construct an m-by-n matrix of zeros.
     * @param m - Number of rows.
     * @param n - Number of columns.
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

    /* GETTERS */

    /**
     * getArray
     *
     * Access the internal two-dimensional array.
    **/
    public double[][] getArray() {
        return matrix;
    }

    /**
     * getArrayCopy
     *
     * Copy the internal two-dimensional array.
    **/
    public double[][] getArrayCopy() {
        double[][] arr = new double[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][i] = matrix[i][j];
            }
        }
        return arr;
    }

    /**
     * getColumnPackedCopy
     *
     * Make a one-dimensional column packed copy of the internal array.
    **/
    public double[] getColumnPackedCopy() {
        double[] arr = new double[length * width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                arr[i+(j*length)] = matrix[i][j];
            }
        }
        return arr;
    }

    /**
     * getRowPackedCopy
     *
     * Make a one-dimensional row packed copy of the internal array.
    **/
    public double[] getRowPackedCopy() {
        double[] arr = new double[length * width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                arr[(i*width)+j] = matrix[i][j];
            }
        }
        return arr;
    }

    /**
     * getRowDimension
     *
     * Get row dimension (length).
    **/
    public int getRowDimension() {
        return length;
    }

    /**
     * getColumnDimension
     *
     * Get column dimension (width).
    **/
    public int getColumnDimension() {
        return width;
    }

    /**
     * get
     *
     * Get a single element.
     * @param i - Row index.
     * @param j - Column index.
     * @throws java.lang.ArrayIndexOutOfBoundsException
     */
    public double get(int i, int j) {
        if (i >= length || j >= width)
            throw new java.lang.ArrayIndexOutOfBoundsException();
        return matrix[i][j];
    }

    //TODO: getMatrix variants
    //      more complicated getters that
    //      return a portion of the matrix

    /* SETTERS */

    /**
     * set
     *
     * Set a single element.
     * @param i - Row index.
     * @param j - Column index.
     * @param s - New value.
     * @throws java.lang.ArrayIndexOutOfBoundsException
    **/
    public void set(int i, int j, double s) {
        if (i >= length || j >= width)
            throw new java.lang.ArrayIndexOutOfBoundsException();
        matrix[i][j] = s;
    }

    //TODO: setMatrix variants
    //      more complicated setters that
    //      set a portion of the matrix

    /* OLD GETTERS/SETTERS */
    /* - TODO: some are used in other files, so those need
     *         to be refactored before these are removed */
              
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
