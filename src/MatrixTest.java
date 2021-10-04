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
	public void testConstructor1() {
		Matrix a = new Matrix(2, 2, 0.0);
		assert(a.getLength() == 2 && a.getWidth() == 2);
		double[][] am = a.getMatrix();
		for (int i = 0; i < a.getLength(); ++i)
			for (int j = 0; j < a.getLength(); ++j)
				assert(am[i][j] == 0.0);
	}

	@Test
	public void testConstructor2() {
		Matrix a = new Matrix(new double[][]{{0., 0.}, {0., 0.}});
		assert(a.getLength() == 2 && a.getWidth() == 2);
		double[][] am = a.getMatrix();
		for (int i = 0; i < a.getLength(); ++i)
			for (int j = 0; j < a.getLength(); ++j)
				assert(am[i][j] == 0.0);
	}
	
}
	