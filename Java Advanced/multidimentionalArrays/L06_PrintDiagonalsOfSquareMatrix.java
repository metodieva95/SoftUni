package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillInMatrix(scanner, matrix);

        // finding primary diagonal
        int row = 0;
        int col = 0;

        while (row < matrix.length && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }

        System.out.println();

        //finding secondary diagonal
        row = matrix.length - 1;
        col = 0;

        while (row >= 0 && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

    }

    private static void fillInMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = currentRow;
        }
    }
}
