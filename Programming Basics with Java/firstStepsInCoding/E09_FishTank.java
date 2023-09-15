package firstStepsInCoding;

import java.util.Scanner;

public class E09_FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCm = Integer.parseInt(scanner.nextLine());
        int widthCm = Integer.parseInt(scanner.nextLine());
        int heightCm = Integer.parseInt(scanner.nextLine());
        double percentageTaken = Double.parseDouble(scanner.nextLine());

        double areaLitres = (lengthCm * widthCm * heightCm) / 1000.0;
        double amountNeeded = areaLitres * (1 - percentageTaken / 100);

        System.out.println(amountNeeded);
    }
}
