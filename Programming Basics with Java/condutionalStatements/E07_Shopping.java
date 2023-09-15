package condutionalStatements;

import java.util.Scanner;

public class E07_Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCardsCount = Integer.parseInt(scanner.nextLine());
        int processorsCount = Integer.parseInt(scanner.nextLine());
        int ramCount = Integer.parseInt(scanner.nextLine());

        double videoCardPrice = 250;
        double processorPrice = (videoCardsCount * videoCardPrice) * 0.35;
        double ramPrice = (videoCardsCount * videoCardPrice) * 0.1;

        double priceWithoutDiscount = (videoCardsCount * videoCardPrice) +
                (processorsCount * processorPrice) + (ramCount * ramPrice);

        double discount = 0;
        if (videoCardsCount > processorsCount) {
            discount = priceWithoutDiscount * 0.15;
        }

        double finalPrice = priceWithoutDiscount - discount;

        if (budget >= finalPrice) {
            System.out.printf("You have %.2f leva left!", budget - finalPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", finalPrice - budget);
        }

    }
}
