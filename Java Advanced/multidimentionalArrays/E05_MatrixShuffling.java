package multidimentionalArrays;

import java.util.Scanner;

public class E05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        fillInMatrix(scanner, matrix);

        String[] inputLine = scanner.nextLine().split("\\s+");

        while (!inputLine[0].equals("END")) {
            String command = inputLine[0];

            if (!validateCommand(inputLine, command)) {
                System.out.println("Invalid input!");
                inputLine = scanner.nextLine().split("\\s+");
                continue;
            }

            int row1 = Integer.parseInt(inputLine[1]);
            int col1 = Integer.parseInt(inputLine[2]);
            int row2 = Integer.parseInt(inputLine[3]);
            int col2 = Integer.parseInt(inputLine[4]);

            if (validateCoordinates(rows, cols, row1, col1, row2, col2)) {
                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            inputLine = scanner.nextLine().split("\\s+");
        }

    }


    private static void fillInMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRowInput = scanner.nextLine().split("\\s+");

            matrix[row] = currentRowInput;
        }
    }

    private static boolean validateCommand(String[] inputLine, String command) {
        if (!command.startsWith("swap")) {
            return false;
        } else if (inputLine.length != 5){
            return false;
        }

        return true;
    }

    private static boolean validateCoordinates(int rows, int cols, int row1, int col1, int row2, int col2) {
        if (row1 > rows || row2 > rows || col1 > cols || col2 > cols) {
            return false;
        }
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
