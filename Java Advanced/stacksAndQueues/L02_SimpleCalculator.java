package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("+") || input[i].equals("-")) {
                operators.offer(input[i]);
            } else {
                numbers.offer(Integer.parseInt(input[i]));
            }
        }

        while (!operators.isEmpty() && numbers.size() >= 1) {
            String operator = operators.poll();
            int firstNumber = numbers.poll();
            int secondNumber = numbers.poll();
            int result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    numbers.offerFirst(result);
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    numbers.offerFirst(result);
                    break;
            }
        }

        System.out.println(numbers.poll());

    }
}
