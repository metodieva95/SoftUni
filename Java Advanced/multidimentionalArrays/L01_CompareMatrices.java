package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0]; //arraysCount
        int columns = dimensions[1]; //sizeOfArray

        int[][] firstMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] inputArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = inputArray;
        }

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        rows = dimensions[0];
        columns = dimensions[1];

        int[][] secondMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] inputArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            secondMatrix[i] = inputArray;
        }

        System.out.println(areEqual(firstMatrix,secondMatrix)
                ? "equal"
                : "not equal");

    }

    public static boolean areEqual(int[][] first, int[][] second)  {
        boolean areEqual = true;

        if (first.length != second.length) {
            areEqual = false;
        }

        for (int r = 0; r < first.length; r++) {

            if (first[r].length != second[r].length) {
                areEqual = false;
                break;
            }

            for (int c = 0; c < second[r].length; c++) {

                if (first[r][c] != second[r][c]) {
                    areEqual = false;
                }
            }
        }

        return areEqual;
    }

    public static void printMatrix (int[][] matrix) {
//        for (int r = 0; r < matrix.length; r++) {
//            for (int c = 0; c < matrix[r].length; c++) {
//                System.out.print(matrix[r][c] + " ");
//            }
//            System.out.println();
//        }

        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
