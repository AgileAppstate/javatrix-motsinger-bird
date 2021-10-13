import javatrix.*;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testTimes1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, 2.0);
		Matrix b = new Matrix(3, 4, 1.0);
		Matrix M = a.times(b);
		double[][] m = M.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 4)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 6)
					fail("Unexpected output.\n");
			}
		}		
	}

	@Test
	public void testTimes2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, 2.0);
		Matrix b = new Matrix(3, 10, 1.0);
		Matrix M = a.times(b);
		double[][] m = M.getMatrix();

		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x10.\n");

		if (M.getWidth() != 10)
			fail("Width incorrect should be 10 for matrices of 2x3 times 3x10.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 6)
					fail("Unexpected output.\n");
			}
		}		
	}

	@Test
	public void testTimes3() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(3, 10, 1.0);
		double b = 6.0;
		Matrix M = a.times(b);
		double[][] m = M.getMatrix();
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 3) 
			fail("Length incorrect should be 3 for matrix of 3x10.\n");

		if (M.getWidth() != 10)
			fail("Width incorrect should be 10 for matrix of 3x10.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 6.0)
					fail("Unexpected output.\n");
			}
		}		
	}	

	@Test
	public void testPlus1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, 2.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.plus(b);
		double[][] m = M.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 3.0)
					fail("Unexpected output.\n");
			}
		}		
	}

	@Test
	public void testPlus2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, -1.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.plus(b);
		double[][] m = M.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 0)
					fail("Unexpected output.\n");
			}
		}		
	}


	@Test
	public void testMinus1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, 2.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.minus(b);
		double[][] m = M.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 1.0)
					fail("Unexpected output.\n");
			}
		}		
	}

	@Test
	public void testMinus2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, -1.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.minus(b);
		double[][] m = M.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != -2.0)
					fail("Unexpected output.\n");
			}
		}		
	}


	@Test
	public void testPlusEquals1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, 2.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.plusEquals(b);
		double[][] m = M.getMatrix();
		double[][] a1 = a.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 3.0)
					fail("Unexpected output.\n");
			}
		}	
		for (int i = 0; i < a.getLength(); ++i) {
			for (int j = 0; j < a.getWidth(); ++j) {
				if (a1[i][j] != 3.0)
					fail("Unexpected output.\n");
			}
		}	
	}

	@Test
	public void testPlusEquals2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, -1.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.plusEquals(b);
		double[][] m = M.getMatrix();
		double[][] a1 = a.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 0)
					fail("Unexpected output.\n");
			}
		}
		for (int i = 0; i < a.getLength(); ++i) {
			for (int j = 0; j < a.getWidth(); ++j) {
				if (a1[i][j] != 0)
					fail("Unexpected output.\n");
			}
		}			
	}


	@Test
	public void testMinusEquals1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, 2.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.minusEquals(b);
		double[][] m = M.getMatrix();
		double[][] a1 = a.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != 1.0)
					fail("Unexpected output.\n");
			}
		}	
		for (int i = 0; i < a.getLength(); ++i) {
			for (int j = 0; j < a.getWidth(); ++j) {
				if (a1[i][j] != 1.0)
					fail("Unexpected output.\n");
			}
		}	
	}

	@Test
	public void testMinusEquals2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(2, 3, -1.0);
		Matrix b = new Matrix(2, 3, 1.0);
		Matrix M = a.minusEquals(b);
		double[][] m = M.getMatrix();
		double[][] a1 = a.getMatrix();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		if (M.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (M.getWidth() != 3)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < M.getLength(); ++i) {
			for (int j = 0; j < M.getWidth(); ++j) {
				if (m[i][j] != -2.0)
					fail("Unexpected output.\n");
			}
		}
		for (int i = 0; i < a.getLength(); ++i) {
			for (int j = 0; j < a.getWidth(); ++j) {
				if (a1[i][j] != -2.0)
					fail("Unexpected output.\n " + a1[i][j] + " " + i + " " + j);
			}
		}		
	}


	@Test
	public void testPrint1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(3, 3, 1.0);
		a.print(1, 2);
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		String s = baos.toString();
		String c = "1.00 1.00 1.00 \n1.00 1.00 1.00 \n1.00 1.00 1.00 \n";

		if (! c.equals(s))
			fail("Unexpected output:\n"+s+"\n");		
	}


	@Test
	public void testPrint2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Matrix a = new Matrix(3, 3, 1.0);
		a.print(8, 2);
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		String s = baos.toString();
		String c = "1.00     1.00     1.00     \n1.00     1.00     1.00     \n1.00     1.00     1.00     \n";

		if (! c.equals(s))
			fail("Unexpected output:\n"+s+"\n");
	}


	@Test
    public void testConstructor0() {
        // Construct an m-by-n matrix of zeros.
        Matrix a = new Matrix(2, 2);
        assert(a.getLength() == 2 && a.getWidth() == 2);
        double[][] am = a.getMatrix();
        for (int i = 0; i < a.getLength(); ++i)
            for (int j = 0; j < a.getWidth(); ++j)
                assert(am[i][j] == 0.0);
    }
    
    
    @Test
	public void testConstructor1() {
        // Construct an m-by-n constant matrix.
		Matrix a = new Matrix(2, 2, 0.0);
		assert(a.getLength() == 2 && a.getWidth() == 2);
		double[][] am = a.getMatrix();
		for (int i = 0; i < a.getLength(); ++i)
			for (int j = 0; j < a.getWidth(); ++j)
				assert(am[i][j] == 0.0);
	}


	@Test
	public void testConstructor2() {
        // Construct a matrix from a 2D array.
		Matrix a = new Matrix(new double[][]{{0., 0.}, {0., 0.}});
		assert(a.getLength() == 2 && a.getWidth() == 2);
		double[][] am = a.getMatrix();
		for (int i = 0; i < a.getLength(); ++i)
			for (int j = 0; j < a.getWidth(); ++j)
				assert(am[i][j] == 0.0);
	}


    @Test
    public void testConstructor3() {
        // Construct a matrix quickly without checking arguments.
        Matrix a = new Matrix(new double[][]{{0., 0.}, {0., 0.}}, 2, 2);
        assert(a.getLength() == 2 && a.getWidth() == 2);
        double[][] am = a.getMatrix();
        for (int i = 0; i < a.getLength(); ++i)
            for (int j = 0; j < a.getWidth(); ++j)
                assert(am[i][j] == 0.0);
    }


    @Test
    public void testConstructor4() {
        // Construct a matrix from a one-dimensional packed array.
        double[] pack = {1.0, 4.0, 7.0,
                         2.0, 5.0, 8.0,
                         3.0, 6.0, 9.0};
        Matrix a = new Matrix(pack, 3);
        assert(a.getLength() == 3 && a.getWidth() == 3);
        double[][] am = a.getMatrix();
        double prev = 0.0;
        for (int i = 0; i < a.getLength(); ++i) {
            for (int j = 0; j < a.getWidth(); ++j) {
                assert(am[i][j] > prev);
                prev = am[i][j];
            }
        }
    }


    @Test
    public void testGetArrayCopy() {
        Matrix a = new Matrix(new double[][]{{0., 0.}, {0., 0.}});
        double[][] copy = a.getArrayCopy();
        double[][] am = a.getMatrix();
        for (int i = 0; i < a.getLength(); ++i)
            for (int j = 0; j < a.getWidth(); ++j)
                assert(am[i][j] == copy[i][j]);
    }
	
}
	
