import javatrix.*;

/**
 * Driver class written as an interactive tester for the Matrix class. 
 * @author: Anthony Bird
 * @version: 0.1
 */
public class Driver {

    /**
     * Main method.
     * @param args - command line args.
     */
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            println("Choose from one of these options:");
            println("1.) Create a matrix");
            println("2.) Multiply created matrix by a scalar");
            println("3.) Multiply created matrix by another matrix");
            println("4.) Print created matrix");
            println("5.) Change the created matrix");
            println("0.) Exit");
            print("\nInput a choice (by number): ");
            
            choice = input.nextInt();
            switch (choice) {
                case 1: create();
                case 2: scalarMultiply();
                case 3: matrixMultiply();
                case 4: printMatrix();
                case 5: changeMatrix();

            }
        }
    }
}