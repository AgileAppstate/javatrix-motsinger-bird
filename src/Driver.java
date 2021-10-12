import javatrix.*;
import java.util.Scanner;

/**
 * Driver class written as an interactive tester for the Matrix class. 
 * @author: Anthony Bird
 * @version: 0.1
 */
public class Driver {

    static Matrix M;
    static Scanner input = new Scanner(System.in);

    /**
     * create method.
     * Creates a matrix using user input. 
     */
    public static void create() {
        System.out.println("\n1.) m * n with all entries being a real number s");
        System.out.println("2.) m * n with inputted rows");
        System.out.print("Please choose a way to create a matrix (1 or 2): ");
        int choice = input.nextInt();
        if (choice == 1 || choice == 2) {
            System.out.print("\nEnter an m: ");
            int m = input.nextInt();
            System.out.print("\nEnter an n: ");
            int n = input.nextInt();
            if (choice == 1) {
                System.out.print("\nEnter an s: ");
                double s = input.nextDouble();
                M = new Matrix(m, n, s);
                M.print(2, 2);
                System.out.println("\nMatrix created. Going back to initial options.");
            }
            else if (choice == 2) {
                double[][] arr = new double[m][n];
                for (int i = 0; i < m; ++i) {
                    System.out.print("\nInput row " + i + ": ");
                    for (int j = 0; j < n; ++j) 
                        arr[i][j] = input.nextDouble();
                }
                M = new Matrix(arr);
                M.print(2, 2);
                System.out.println("\nMatrix created. Going back to initial options.");
            }
        }
        else
            System.out.println("\nInvalid choice. Going back to initial options.");
    }


    public static void scalarMultiply() {
        System.out.print("\nEnter a scalar to multiply your matrix by: ");
        double s = input.nextDouble();
        M = M.times(s);
        M.print(2, 2);
        System.out.println("Scalar multiplication complete. Going back to initial options.");
    }


    public static void matrixMultiply() {
        System.out.println("\n1.) m * n with all entries being a real number s");
        System.out.println("2.) m * n with inputted rows");
        System.out.print("Please choose a way to create a matrix to multiply by (1 or 2): ");
        int choice = input.nextInt();
        Matrix k = new Matrix(M.getLength(), M.getWidth(), 1.0);
        if (choice == 1 || choice == 2) {
            System.out.print("\nEnter an m: ");
            int m = input.nextInt();
            System.out.print("\nEnter an n: ");
            int n = input.nextInt();
            if (choice == 1) {
                System.out.print("\nEnter an s: ");
                double s = input.nextDouble();
                k = new Matrix(m, n, s);
            }
            else if (choice == 2) {
                double[][] arr = new double[m][n];
                for (int i = 0; i < m; ++i) {
                    System.out.print("\nInput row " + i + ": ");
                    for (int j = 0; j < n; ++j) 
                        arr[i][j] = input.nextDouble();
                }
                k = new Matrix(arr);
            }
        }
        M = M.times(k);
        M.print(2, 2);
        System.out.println("Matrix multiplication complete. Going back to initial options.");
    }


    public static void printMatrix() {
        System.out.println();
        M.print(2, 2);
    }


    /**
     * Main method.
     * @param args - command line args.
     */
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\nChoose from one of these options:");
            System.out.println("1.) Create a matrix");
            System.out.println("2.) Multiply created matrix by a scalar");
            System.out.println("3.) Multiply created matrix by another matrix");
            System.out.println("4.) Print created matrix");
            System.out.println("5.) Change the created matrix");
            System.out.println("0.) Exit");
            System.out.print("Input a choice (by number): ");
            
            choice = input.nextInt();
            switch (choice) {
                case 1: create();
                        break;
                case 2: scalarMultiply();
                        break;
                case 3: matrixMultiply();
                        break;
                case 4: printMatrix();
                        break;
                case 5: create();
                        break;
                case 0: System.exit(0);
            }
        }
        input.close();
    }
}