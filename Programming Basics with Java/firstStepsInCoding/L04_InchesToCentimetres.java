package firstStepsInCoding;

import java.util.Scanner;

public class L04_InchesToCentimetres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberInInches = Double.parseDouble(scanner.nextLine());
        double rate = 2.54;
        double numberInCm = numberInInches * rate;

        System.out.println(numberInCm);
    }
}
