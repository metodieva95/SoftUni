package firstStepsInCoding;

import java.util.Scanner;

public class E05_SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pensPrice = 5.8;
        double markersPrice = 7.2;
        double detergentPrice = 1.2; // per litre

        int pensCount = Integer.parseInt(scanner.nextLine());
        int markersCount = Integer.parseInt(scanner.nextLine());
        int detergentLitres = Integer.parseInt(scanner.nextLine());
        int discountPercentage = Integer.parseInt(scanner.nextLine());

        double totalPensPrice = pensPrice * pensCount;
        double totalMarkersPrice = markersPrice * markersCount;
        double totalDetergentPrice = detergentPrice * detergentLitres;

        double totalPrice = totalPensPrice + totalMarkersPrice + totalDetergentPrice;
        double discount = totalPrice * discountPercentage / 100;

        System.out.println(totalPrice - discount);
    }
}
