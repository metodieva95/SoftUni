package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E03_NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeFlowers = scanner.nextLine();
        int nrFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;
        if (typeFlowers.equals("Roses")) {
            totalPrice = nrFlowers * 5.0;
            if (nrFlowers > 80){
                totalPrice = totalPrice - (totalPrice * 0.10);
            }
        }

        if (typeFlowers.equals("Dahlias")) {
            totalPrice = nrFlowers * 3.80;
            if (nrFlowers > 90){
                totalPrice = totalPrice - (totalPrice * 0.15);
            }
        }

        if (typeFlowers.equals("Tulips")) {
            totalPrice = nrFlowers * 2.80;
            if (nrFlowers > 80) {
                totalPrice = totalPrice - (totalPrice * 0.15);
            }
        }

        if (typeFlowers.equals("Narcissus")){
            totalPrice = nrFlowers * 3.0;
            if (nrFlowers < 120){
                totalPrice = totalPrice + (totalPrice * 0.15);
            }
        }

        if (typeFlowers.equals("Gladiolus")){
            totalPrice = nrFlowers * 2.50;
            if (nrFlowers < 80) {
                totalPrice = totalPrice + (totalPrice * 0.20);
            }
        }

        double difference = Math.abs(budget-totalPrice);

        if (budget >= totalPrice){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    nrFlowers, typeFlowers, difference);
        } else if (budget < totalPrice){
            System.out.printf("Not enough money, you need %.2f leva more.", difference);
        }
    }
}
