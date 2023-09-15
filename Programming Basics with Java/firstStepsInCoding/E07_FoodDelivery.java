package firstStepsInCoding;

import java.util.Scanner;

public class E07_FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenus = Integer.parseInt(scanner.nextLine());
        int fishMenus = Integer.parseInt(scanner.nextLine());
        int vegetarianMenus = Integer.parseInt(scanner.nextLine());

        double chickenPrice = 10.35;
        double fishPrice = 12.4;
        double vegetarianPrice = 8.15;

        double totalPrice = (chickenPrice * chickenMenus) + (fishPrice * fishMenus) + (vegetarianPrice * vegetarianMenus);
        double desertPrice = totalPrice * 0.2;

        double orderPrice = totalPrice + desertPrice + 2.5;
        System.out.printf("%.2f", orderPrice);
    }
}
