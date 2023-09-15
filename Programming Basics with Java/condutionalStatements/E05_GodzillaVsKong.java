package condutionalStatements;

import java.util.Scanner;

public class E05_GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int stunts = Integer.parseInt(scanner.nextLine());
        double equipmentPerStuntPrice = Double.parseDouble(scanner.nextLine());
        double decorPrice = budget * 0.1;

        if (stunts >= 150) {
            equipmentPerStuntPrice = 0.9 * equipmentPerStuntPrice;
        }

        double totalExpenses = (equipmentPerStuntPrice * stunts) + decorPrice;

        if (totalExpenses > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", Math.abs(totalExpenses - budget));
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", Math.abs(totalExpenses - budget));
        }

    }
}
