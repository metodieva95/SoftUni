package firstStepsInCoding;

import java.util.Scanner;

public class E08_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearlyTax = Integer.parseInt(scanner.nextLine());

        double shoesPrice = yearlyTax - (yearlyTax * 0.4);
        double suitPrice = shoesPrice - (shoesPrice * 0.2);
        double ballPrice = suitPrice * 1/4;
        double accessoriesPrice = ballPrice * 1/5;

        double amountNeeded = yearlyTax + shoesPrice + suitPrice + ballPrice + accessoriesPrice;
        System.out.printf("%.2f", amountNeeded);
    }
}
