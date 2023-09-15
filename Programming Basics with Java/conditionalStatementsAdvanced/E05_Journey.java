package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E05_Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        double amountSpent = 0;
        String stayingAt = "";
        if (budget <= 100) {
            destination = "Bulgaria";

            switch (season) {
                case "summer":
                    amountSpent = budget * 0.3;
                    break;
                case "winter":
                    amountSpent = budget * 0.7;
                    break;
            }

        } else if (budget <= 1000) {
            destination = "Balkans";

            switch (season) {
                case "summer":
                    amountSpent = budget * 0.4;
                    break;
                case "winter":
                    amountSpent = budget * 0.8;
                    break;
            }

        } else {
            destination = "Europe";
            amountSpent = budget * 0.9;

        }

        if (season.equals("summer") && !destination.equals("Europe")) {
            stayingAt = "Camp";
        } else {
            stayingAt = "Hotel";
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", stayingAt, amountSpent);
    }
}
