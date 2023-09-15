package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        ArrayDeque<String> openingBrackets = new ArrayDeque<>();
        ArrayDeque<String> closingBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {

            if (input[i].equals("(") || input[i].equals("[") || input[i].equals("{")) {
                openingBrackets.offer(input[i]);
            } else if (input[i].equals(")") || input[i].equals("]") || input[i].equals("}")) {
                closingBrackets.push(input[i]);
            }

        }

        System.out.println(isMatching(openingBrackets, closingBrackets)
                ? "YES"
                : "NO");
    }

    public static boolean isMatching(ArrayDeque<String> openingBrackets, ArrayDeque<String> closingBrackets) {

        boolean isMatching = false;

        if (openingBrackets.size() == closingBrackets.size()) {
            isMatching = true;
        }

        for (int i = 0; i < openingBrackets.size(); i++) {
            String currentOpening = openingBrackets.poll();
            String currentClosing = closingBrackets.pop();

            if (currentOpening.equals("(") && currentClosing.equals(")")) {
                isMatching = true;
            } else if (currentOpening.equals("[") && currentClosing.equals("]")){
                isMatching = true;
            }else if (currentOpening.equals("{") && currentClosing.equals("}")) {
                isMatching = true;
            } else {
                isMatching = false;
                break;
            }
        }

        return isMatching;
    }
}
