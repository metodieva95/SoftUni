package condutionalStatements;

import java.util.Scanner;

public class E03_TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        if (min + 15 >= 60) {
            hour += 1;
            min -= 45;
        } else {
            min += 15;
        }

        if (hour > 23) {
            hour = 0;
        }

        System.out.printf("%d:%02d", hour, min);
    }
}
