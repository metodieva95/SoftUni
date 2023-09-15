package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        char[] expressionArr = expression.toCharArray();

        ArrayDeque<Integer> brackets = new ArrayDeque<>();

        for (int i = 0; i < expressionArr.length ; i++) {
            char currentCharacter = expressionArr[i];

            if (currentCharacter == '(') {
                brackets.push(i);
            } else if (currentCharacter == ')') {
                int startIndex = brackets.pop();
                int endIndex = i + 1;
                String subExpression = expression.substring(startIndex, endIndex);

                System.out.println(subExpression);
            }
        }

    }
}
