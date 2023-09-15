package conditionalStatementsAdvanced;

import java.util.Scanner;

public class L06_NumbersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number != 0 && number >= -100 && number <= 100) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
