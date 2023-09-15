package firstStepsInCoding;

import java.util.Scanner;

public class E06_Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylonCount = Integer.parseInt(scanner.nextLine());
        int paintCount = Integer.parseInt(scanner.nextLine());
        int detergentCount = Integer.parseInt(scanner.nextLine());
        int hoursWork = Integer.parseInt(scanner.nextLine());

        double nylonPrice = 1.5;
        double paintPrice = 14.5;
        double detergentPrice = 5;

        double materialsPrice = ((nylonCount + 2) * nylonPrice) + ((1.1 * paintCount) * paintPrice)
                + (detergentCount * detergentPrice) + 0.4;

       double workPrice = (materialsPrice * 0.3) * hoursWork;

        System.out.printf("%.2f", materialsPrice + workPrice);
    }
}
