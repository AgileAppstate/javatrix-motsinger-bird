public class Matrix {
    private double[][] matrix;
    private int length;
    private int width;

    /**
     * times method. Multiplies the matrix by a scalar product.  
     * @param s - the scalar.
    **/
    public void times(double s) {
        for (int i = 0; i < length; ++i)
	    for (int j = 0; j < width; ++j)
		matrix[i][j] *= s;
    }

    /**
     * times method. Multiplies the matrix by another matrix B.
     * @param B - the matrix to multiply by. Must be of form width * p.
     * @throws IllegalArguementException - Thrown when inner dimensions are not equal. 
    **/
    public void times(Matrix B) {
        if (width != B.getLength())
	    throw new java.lang.IllegalArgumentException("Matrix inner dimensions must agree"); 
        double[][] result = new double[length][B.getWidth()];
        double cell = 0;
	    double[][] b_matrix = B.getMatrix();
	    for (int i = 0; i < result.length; ++i) {}
            for (int j = 0; j < result[0].length; ++j) {
	            for (int k = 0; k < B.getLength(); ++k)
		            cell += matrix[i][k] * b_matrix[k][j];
		        result[i][j] = cell;
		        cell = 0;
            }
        }
    }

    /**
     * getMatrix method. Public accessor for the matrix field. 
    **/
    public Matrix getMatrix() {
        return matrix;
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
}
