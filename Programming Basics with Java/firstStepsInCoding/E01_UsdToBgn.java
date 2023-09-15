package firstStepsInCoding;

import java.util.Scanner;

public class E01_UsdToBgn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usd = Double.parseDouble(scanner.nextLine());
        double rate = 1.79549;

        double bgn = usd * rate;

        System.out.println(bgn);
    }
}
