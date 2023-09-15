package multidimentionalArrays;

import java.util.Scanner;

public class E01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        int size = Integer.parseInt(data[0]);
        String pattern = data[1];

        int[][] matrix = new int[size][size];

        int counter = 1;
        
        switch (pattern) {
            case "A":
                fillMatrixPatternA(size, matrix, counter);
                break;
            case "B":
                getFillMatrixPatternB(size, matrix, counter);
                break;
        }

        printMatrix(size, matrix);

    }

    private static void fillMatrixPatternA(int size, int[][] matrix, int counter) {

        for (int col = 0; col < size; col++) {
            
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }

        }
    }

    private static void getFillMatrixPatternB(int size, int[][] matrix, int counter) {

        for (int col = 0; col < size; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }

        }

    }

    private static void printMatrix(int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
