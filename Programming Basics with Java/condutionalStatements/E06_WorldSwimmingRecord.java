package condutionalStatements;

import java.util.Scanner;

public class E06_WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double worldRecord = Double.parseDouble(scanner.nextLine());
        double distanceInMetres = Double.parseDouble(scanner.nextLine());
        double timePerMeter = Double.parseDouble(scanner.nextLine());

        double timeToSwim = (distanceInMetres * timePerMeter) + Math.floor((distanceInMetres / 15)) * 12.5;

        if (worldRecord <= timeToSwim) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(worldRecord - timeToSwim));
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeToSwim);
        }
    }
}
