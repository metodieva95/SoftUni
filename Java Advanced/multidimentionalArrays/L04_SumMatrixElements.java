package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = input;
        }

        int sum = 0;

        for (int[] row : matrix) {
            for (int col = 0; col < row.length; col++) {
                sum += row[col];
            }
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);

    }
}
