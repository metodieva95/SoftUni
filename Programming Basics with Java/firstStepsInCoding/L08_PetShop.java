package firstStepsInCoding;

import java.util.Scanner;

public class L08_PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dogFoodPrice = 2.5;
        double catFoodPrice = 4;

        int dogFoodCount = Integer.parseInt(scanner.nextLine());
        int catFoodCount = Integer.parseInt(scanner.nextLine());

        double result = (dogFoodCount * dogFoodPrice) + (catFoodCount * catFoodPrice);

        System.out.printf("%.2f lv.", result);
    }
}
