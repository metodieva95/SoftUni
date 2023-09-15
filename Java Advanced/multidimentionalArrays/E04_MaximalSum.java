package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();
      
      int rows = dimensions[0];
      int cols = dimensions[1];
      
      int[][] matrix = new int[rows][cols];

        fillInMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;

        int bestStartingRow = 0;
        int bestStartingCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col]+ matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

//                for (int currentRow = row; currentRow < row + 3; currentRow++) {
//                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
//                        sum += matrix[currentRow][currentCol];
//                    }
//                }

                if (sum > maxSum) {
                    maxSum = sum;
                    bestStartingRow = row;
                    bestStartingCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);

        for (int row = bestStartingRow; row < bestStartingRow + 3; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void fillInMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] rowInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = rowInput;
        }
    }
}
