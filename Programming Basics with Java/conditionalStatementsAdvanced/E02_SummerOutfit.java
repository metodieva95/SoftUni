package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E02_SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (degrees >= 10 && degrees <= 18) {
            if (dayTime.equals("Morning")) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (dayTime.equals("Afternoon") || dayTime.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (degrees > 18 && degrees <= 24) {
            if (dayTime.equals("Morning") || dayTime.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (dayTime.equals("Afternoon")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        } else if (degrees > 24) {
            if (dayTime.equals("Morning")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (dayTime.equals("Afternoon")) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            } else if (dayTime.equals("Evening")){
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
    }
}
