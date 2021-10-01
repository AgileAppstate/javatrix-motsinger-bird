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
		a.times(b);
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		double[][] m = a.getMatrix();
		if (a.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x4.\n");

		if (a.getWidth() != 4)
			fail("Width incorrect should be 4 for matrices of 2x3 times 3x4.\n");

		// Check for desired result
		for (int i = 0; i < a.getLength(); ++i) {
			for (int j = 0; j < a.getWidth(); ++j) {
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
		a.times(b);
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		double[][] m = a.getMatrix();
		if (a.getLength() != 2) 
			fail("Length incorrect should be 2 for matrices of 2x3 times 3x10.\n");

		if (a.getWidth() != 10)
			fail("Width incorrect should be 10 for matrices of 2x3 times 3x10.\n");

		// Check for desired result
		for (int i = 0; i < a.getLength(); ++i) {
			for (int j = 0; j < a.getWidth(); ++j) {
				if (m[i][j] != 6)
					fail("Unexpected output.\n");
			}
		}		
	}
}
	