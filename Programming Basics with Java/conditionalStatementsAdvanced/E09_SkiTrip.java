package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E09_SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();

        double price = 0;
        switch (roomType) {
            case "room for one person":
                price = 18;
                break;
            case "apartment":
                price = 25;
                if (days < 10) {
                    price = (price * 0.7);
                } else if (days > 10 && days <= 15) {
                    price = (price * 0.65);
                } else if (days > 15) {
                    price = (price * 0.5);
                }
                break;
            case "president apartment":
                price = 35;
                if (days < 10) {
                    price = (price * 0.9);
                } else if (days > 10 && days <= 15) {
                    price = (price * 0.85);
                } else if (days > 15) {
                    price = (price * 0.8);
                }
                break;
        }

        switch (rating) {
            case "positive":
                price = 1.25 * price;
                break;
            case "negative":
                price = 0.9 * price;
                break;
        }

        System.out.printf("%.2f", price * (days - 1));

    }
}
