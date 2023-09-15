package condutionalStatements;

import java.util.Scanner;

public class E04_ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzleCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int bearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());

        double puzzlePrice = 2.6;
        double dollsPrice = 3;
        double bearsPrice = 4.1;
        double minionsPrice = 8.2;
        double trucksPrice = 2;

        double totalPrice = (puzzleCount * puzzlePrice)
                + (dollsCount * dollsPrice)
                + (bearsCount * bearsPrice)
                + (minionsCount * minionsPrice)
                + (trucksCount * trucksPrice);

        int totalCount = puzzleCount + dollsCount + bearsCount + minionsCount + trucksCount;

        double discount = 0;
        if (totalCount >= 50) {
            discount = totalPrice * 0.25;
        }

        double priceWithDiscount = totalPrice - discount;

        double rent = priceWithDiscount * 0.1;
        double profit = priceWithDiscount - rent;

        if (profit >= vacationPrice) {
            System.out.printf("Yes! %.2f lv left.", profit - vacationPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", vacationPrice - profit);
        }
    }
}
