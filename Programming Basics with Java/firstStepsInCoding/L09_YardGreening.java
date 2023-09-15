package firstStepsInCoding;

import java.util.Scanner;

public class L09_YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerSqMInclVat = 7.61;
        // 18% discount from final price

        double squareMetres = Double.parseDouble(scanner.nextLine());

        double finalPrice = squareMetres * pricePerSqMInclVat;
        double discount = finalPrice * 0.18;

        System.out.printf("The final price is: %.2f lv.%n", finalPrice - discount);
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}
