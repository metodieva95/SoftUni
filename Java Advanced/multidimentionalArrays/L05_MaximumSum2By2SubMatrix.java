package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L05_MaximumSum2By2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillInMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {

                int sum = getSum(matrix, r, c);

                if (sum > maxSum) {
                    maxSum = sum;

                    fillInSubMatrix(matrix, subMatrix, r, c);
                }
            }
        }

        printResult(maxSum, subMatrix);

    }

    private static void fillInMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = currentRow;
        }
    }

    private static int getSum(int[][] matrix, int r, int c) {
        int sum = matrix[r][c] + matrix[r][c + 1] +
                matrix[r + 1][c] + matrix[r + 1][c + 1];
        return sum;
    }

    private static void fillInSubMatrix(int[][] matrix, int[][] subMatrix, int r, int c) {
        subMatrix[0][0] = matrix[r][c];
        subMatrix[0][1] = matrix[r][c + 1];
        subMatrix[1][0] = matrix[r + 1][c];
        subMatrix[1][1] = matrix[r + 1][c + 1];
    }

    private static void printResult(int maxSum, int[][] subMatrix) {
        for (int[] arr : subMatrix) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
