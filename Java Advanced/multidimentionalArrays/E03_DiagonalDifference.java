package multidimentionalArrays;

import java.util.Scanner;

public class E03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillInMatrix(scanner, size, matrix);

        int primaryDiagonalSum = findPrimaryDiagonalSum(size, matrix);

        int secondaryDiagonalSum = findSecondaryDiagonalSum(size, matrix);

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));

    }

    private static int findSecondaryDiagonalSum(int size, int[][] matrix) {
        int secondaryDiagonalSum = 0;

//        for (int row = size - 1, col = 0; col < size && row >= 0 ; row--, col++) {
//            secondaryDiagonalSum += matrix[row][col];
//        }

        for (int row = 0; row < size; row++) {
            secondaryDiagonalSum += matrix[row][size - 1 - row];
        }

        return secondaryDiagonalSum;
    }

    private static int findPrimaryDiagonalSum(int size, int[][] matrix) {
        int primaryDiagonalSum = 0;

        for (int index = 0; index < size; index++) {
            primaryDiagonalSum += matrix[index][index];
        }

//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                if (row == col) {
//                    primaryDiagonalSum += matrix[row][col];
//                }
//            }
//        }
        
        return primaryDiagonalSum;
    }

    private static void fillInMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(rowInput[col]);
            }
        }
    }
}
