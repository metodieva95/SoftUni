package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E07_HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;
        switch (month) {
            case "May":
            case "October":
                priceStudio = 50;
                priceApartment = 65;
                if (nightsCount > 7 && nightsCount <= 14) {
                    priceStudio = (priceStudio * 0.95) * nightsCount;
                    priceApartment = priceApartment * nightsCount;
                } else if (nightsCount > 14) {
                    priceStudio = (priceStudio * 0.7) * nightsCount;
                    priceApartment = (priceApartment * 0.9) * nightsCount;
                } else {
                    priceStudio = priceStudio * nightsCount;
                    priceApartment = priceApartment * nightsCount;
                }
                break;
            case "June":
            case "September":
                priceStudio = 75.2;
                priceApartment = 68.7;
                if (nightsCount > 14) {
                    priceStudio = (priceStudio * 0.8) * nightsCount;
                    priceApartment = (priceApartment * 0.9) * nightsCount;
                } else {
                    priceStudio = priceStudio * nightsCount;
                    priceApartment = priceApartment * nightsCount;
                }
                break;
            case "July":
            case "August":
                priceStudio = 76;
                priceApartment = 77;
                if (nightsCount > 14) {
                    priceStudio = priceStudio * nightsCount;
                    priceApartment = (priceApartment * 0.9) * nightsCount;
                } else {
                    priceStudio = priceStudio * nightsCount;
                    priceApartment = priceApartment * nightsCount;
                }
                break;
        }

        System.out.printf("Apartment: %.2f lv.%n", priceApartment);
        System.out.printf("Studio: %.2f lv.", priceStudio);
    }
}
