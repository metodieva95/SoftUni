package firstStepsInCoding;

import java.util.Scanner;

public class E03_DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositedAmount = Double.parseDouble(scanner.nextLine());
        int monthsDeposited = Integer.parseInt(scanner.nextLine());
        double yearlyInterestRate = Double.parseDouble(scanner.nextLine());

        double monthlyRate = (depositedAmount * yearlyInterestRate / 100) / 12;
        double finalAmount = depositedAmount + (monthsDeposited * monthlyRate);

        System.out.println(finalAmount);
    }
}
