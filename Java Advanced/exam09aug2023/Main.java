package exam09aug2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        int initialBoyRow = 0;
        int initialBoyCol = 0;

//        int boyRow = 0;
//        int boyCol = 0;

        for (int row = 0; row < rows; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;

            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 'B') {
                    initialBoyRow = row;
                    initialBoyCol = col;
//                    boyRow = initialBoyRow;
//                    boyCol = initialBoyCol;
                }
            }
        }


        System.out.println();


    }
}
