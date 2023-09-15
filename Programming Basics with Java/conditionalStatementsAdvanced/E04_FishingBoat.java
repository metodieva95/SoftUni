package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E04_FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int nrFishermen = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (season){
            case "Spring":
                price = 3000;
                break;
            case "Summer":
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }

        if (nrFishermen <= 6) {
            price = price * 0.90;
        }else if (nrFishermen <=11){
            price = price * 0.85;
        }else if (nrFishermen >12){
            price = price * 0.75;
        }

        if (nrFishermen % 2 == 0 && !season.equals("Autumn")) {
            price = price * 0.95;
        }

        double difference = Math.abs(budget-price);

        if (budget >= price){
            System.out.printf("Yes! You have %.2f leva left.", difference);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.", difference);
        }
    }
}
