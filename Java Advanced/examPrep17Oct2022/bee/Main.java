package examPrep17Oct2022.bee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[n][n];
        int beeRow = -1;
        int beeCol = -1;

        for (int i = 0; i < n; i++) {
            char[] inputRow = scanner.nextLine().toCharArray();

            for (int j = 0; j < n; j++) {
                territory[i][j] = inputRow[j];
                if (territory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }

        }

        int pollinatedFlowersSum = 0;

        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            territory[beeRow][beeCol] = '.';

            if (command.equals("right") && beeCol != territory.length - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else if (command.equals("down") && beeRow != territory.length - 1) {
                beeRow++;
            } else {
                territory[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[beeRow][beeCol] == 'f') {
                pollinatedFlowersSum++;
            }

            if (territory[beeRow][beeCol] == 'O') {
                continue;
            }

            territory[beeRow][beeCol] = 'B';

            command = scanner.nextLine();
        }

        if (pollinatedFlowersSum < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowersSum);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowersSum);
        }

        for (char[] arr : territory) {
                for (char c : arr) {
                    System.out.print(c);
                }
                System.out.println();
            }

    }


}
