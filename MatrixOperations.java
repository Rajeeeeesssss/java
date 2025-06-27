import java.util.Scanner;

// Matrix class to encapsulate matrix properties and methods
class Matrix {
    private int rows, cols;
    private double[][] data;

    // Constructor 
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Method to fill the matrix with user input
    public void fillMatrix(Scanner scanner) {
        System.out.println("Enter elements of the matrix (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = scanner.nextDouble();
            }
        }
    }

    // Method to print the matrix
    public void printMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to add two matrices
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to add.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to subtract.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Number of columns of the first matrix must equal the number of rows of the second matrix.");
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    // Method to compute the transpose of the matrix
    public Matrix transpose() {
        Matrix transposed = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed.data[j][i] = data[i][j];
            }
        }
        return transposed;
    }
        // Method to display the matrix
        public void displayMatrix() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(data[i][j] + "\t");
                }
                System.out.println();
            }
        }
    
}

// Main class to handle user interaction
public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matrix Operations Program");

        // Creating the first matrix
        System.out.print("Enter rows and columns for Matrix 1: ");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        Matrix matrix1 = new Matrix(rows1, cols1);
        matrix1.fillMatrix(scanner);
    
        // Creating the second matrix if needed
        Matrix matrix2 = null;
        System.out.print("Do you want to input a second matrix? for yes (1) for no (0): ");
        if (scanner.next().equalsIgnoreCase("1")) {
            System.out.print("Enter rows and columns for Matrix 2: ");
            int rows2 = scanner.nextInt();
            int cols2 = scanner.nextInt();
            matrix2 = new Matrix(rows2, cols2);
            matrix2.fillMatrix(scanner);
        }
        System.out.println("Original Matrix1:");
        matrix1.displayMatrix();
        System.out.println("Original Matrix2:");
        matrix2.displayMatrix();


        // Menu-driven system for operations
        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add Matrices");
            System.out.println("2. Subtract Matrices");
            System.out.println("3. Multiply Matrices");
            System.out.println("4. Transpose Matrix 1");
            System.out.println("5. Transpose Matrix 2");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (matrix2 != null) {
                        try {
                            System.out.println("Result of Addition:");
                            matrix1.add(matrix2).printMatrix();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Second matrix not provided.");
                    }
                    break;

                case 2:
                    if (matrix2 != null) {
                        try {
                            System.out.println("Result of Subtraction:");
                            matrix1.subtract(matrix2).printMatrix();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Second matrix not provided.");
                    }
                    break;

                case 3:
                    if (matrix2 != null) {
                        try {
                            System.out.println("Result of Multiplication:");
                            matrix1.multiply(matrix2).printMatrix();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Second matrix not provided.");
                    }
                    break;

                case 4:
                    System.out.println("Transpose of Matrix 1:");
                    matrix1.transpose().printMatrix();
                    break;

                case 5:
                    if (matrix2 != null) {
                        System.out.println("Transpose of Matrix 2:");
                        matrix2.transpose().printMatrix();
                    } else {
                        System.out.println("Second matrix not provided.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
