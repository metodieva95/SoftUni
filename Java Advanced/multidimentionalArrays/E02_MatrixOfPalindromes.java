package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillInMatrix(rows, cols, matrix);

        printMatrix(rows, cols, matrix);

    }

    private static void fillInMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                char outsideLetter = (char) ('a' + row);
                char middleLetter = (char) ('a' + row + col);

                matrix[row][col] = String.valueOf(outsideLetter) + middleLetter + outsideLetter;
            }
        }
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
