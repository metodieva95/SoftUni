package multidimentionalArrays;

import java.util.Scanner;

public class L03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayCount = Integer.parseInt(scanner.nextLine());
        int sizeOfArray = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix = new String[arrayCount][sizeOfArray];
        String [][] secondMatrix = new String[arrayCount][sizeOfArray];

        String [][] alteredMatrix = firstMatrix;

        //fill the first matrix
        for (int row = 0; row < arrayCount; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            firstMatrix[row] = input;
        }

        //fill the second matrix
        for (int row = 0; row < arrayCount; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            secondMatrix[row] = input;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {

                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    alteredMatrix[row][col] = "*";
                }
            }
        }

        for (String[] arr : alteredMatrix) {
            for (String character : arr) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
}
