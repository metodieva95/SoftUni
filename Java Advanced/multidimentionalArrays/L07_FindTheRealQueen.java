package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        System.out.println();
    }
}
