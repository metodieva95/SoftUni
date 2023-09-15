package exam09aug2023;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        int initialBoyRow = 0;
        int initialBoyCol = 0;

        int boyRow = 0;
        int boyCol = 0;

        for (int row = 0; row < rows; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;

            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 'B') {
                    initialBoyRow = row;
                    initialBoyCol = col;
                    boyRow = initialBoyRow;
                    boyCol = initialBoyCol;
                }
            }

        }

        boolean isAFound = false;
        boolean isLost = false;

        String command = scanner.nextLine();
        while (boyRow > 0 && boyCol > 0
                && boyRow != matrix.length + 1 && boyCol != matrix.length + 1
                || isAFound) {

            if (matrix[boyRow][boyCol] == '*') {
                command = scanner.nextLine();
                continue;
            } else if (matrix[boyRow][boyCol] == 'R') {
                matrix[boyRow][boyCol] = 'R';
            } else {
                matrix[boyRow][boyCol] = '.';
            }

            if (command.equals("up")) {
                boyRow--;

            } else if (command.equals("down")) {
                boyRow++;

            } else if (command.equals("right")) {
                boyCol++;

            } else if (command.equals("left")) {
                boyCol--;

            } else {
                isLost = true;
               break;
            }

            if (matrix[boyRow][boyCol] == 'P') {
                matrix[boyRow][boyCol] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (matrix[boyRow][boyCol] == 'A') {
                isAFound = true;
                matrix[boyRow][boyCol] = 'P';
                break;
            } else {
                matrix[boyRow][boyCol] = 'B';
            }

            command = scanner.nextLine();
        }

        if (isAFound) {
            matrix[initialBoyRow][initialBoyCol] = 'B';
            System.out.println("Pizza is delivered on time! Next order...");
        } else if (isLost) {
            System.out.println("The delivery is late. Order is canceled.");
        }

        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }

    }


}
