package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int arrayCount = dimensions[0];
        int sizeOfArray = dimensions[1];

        int[][] matrix = new int[arrayCount][sizeOfArray];

        for (int i = 0; i < arrayCount; i++) {
            int[] inputMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = inputMatrix;
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        isNumberFound(matrix, numberToFind);


    }

    private static void isNumberFound(int[][] matrix, int numberToFind) {
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == numberToFind) {
                    System.out.println(row + " " +  col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }

    }
}
