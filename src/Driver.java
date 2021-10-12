import javatrix.*;

/**
 * Driver class written as an interactive tester for the Matrix class. 
 * @author: Anthony Bird
 * @version: 0.1
 */
public class Driver {

    static Matrix m;
    static Scanner input = new Scanner(System.in);

    public static void create() {
        System.out.println("\n1.) m * n with all entries being a real number s");
        System.out.println("2.) m * n with inputted rows")
        System.out.print("Please choose away to create a matrix (1 or 2): ");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.print("\nEnter an m: ");
            int m = input.nextInt();
            System.out.print("\nEnter an n: ");
            int n = input.nextInt();
            System.out.print("\nEnter an s: ");
            double s = input.nextDouble();
            m = new Matrix(m, n, s);
            System.out.println("\nMatrix created. Going back to initial options.");
        }
        else if (choice == 2) {
            System.out.print("\nEnter an m: ");
            int m = input.nextInt();
            System.out.print("\nEnter an n: ");
            int n = input.nextInt();
            double[][] arr = new double[m][n]();
            for (int i = 0; i < m; ++i) {
                System.out.print("Input row " + i + ": ");
                
            }
        }
        else
            System.out.println("\nInvalid choice. Going back to initial options.");
    }

    /**
     * Main method.
     * @param args - command line args.
     */
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            println("\nChoose from one of these options:");
            println("1.) Create a matrix");
            println("2.) Multiply created matrix by a scalar");
            println("3.) Multiply created matrix by another matrix");
            println("4.) Print created matrix");
            println("5.) Change the created matrix");
            println("0.) Exit");
            print("Input a choice (by number): ");
            
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
                case 5: changeMatrix();
                        break;
                case 0: System.exit(0);
            }
        }
        input.close();
    }
}