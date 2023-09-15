package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E06_OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);

        double result = 0;
        String evenOrOdd = "";
        boolean isZero = false;

        if (operator == '+') {
            result = firstNumber + secondNumber;
            if (result % 2 == 0){
                evenOrOdd = "even";
            }else{
                evenOrOdd = "odd";
            }
        }

        if (operator == '-'){
            result = firstNumber - secondNumber;
            if (result % 2 == 0){
                evenOrOdd = "even";
            }else{
                evenOrOdd = "odd";
            }
        }

        if (operator == '*') {
            result = firstNumber * secondNumber;
            if (result % 2 == 0){
                evenOrOdd = "even";
            }else{
                evenOrOdd = "odd";
            }
        }

        if (operator == '/') {
            if (secondNumber != 0){
                result = firstNumber * 1.0 / secondNumber;
            }else{
                isZero = true;
            }
        }

        if (operator == '%'){
            if (secondNumber != 0){
                result = firstNumber % secondNumber;
            }else {
                isZero = true;
            }
        }

        if (operator == '+' || operator == '-' || operator == '*'){
            System.out.printf("%d %c %d = %.0f - %s", firstNumber, operator, secondNumber, result, evenOrOdd);
        } else if (operator == '/' && !isZero){
            System.out.printf("%d %c %d = %.2f", firstNumber, operator, secondNumber, result);
        }else if (operator == '%' && !isZero){
            System.out.printf("%d %c %d = %.0f", firstNumber, operator, secondNumber, result);
        } else if (isZero && operator == '/' || operator == '%') {
            System.out.printf("Cannot divide %d by zero", firstNumber);
        }

    }

}
