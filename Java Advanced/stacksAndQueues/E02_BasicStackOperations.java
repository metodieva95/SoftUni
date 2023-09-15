package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E02_BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPush = inputLine[0];
        int elementsToPop = inputLine[1];
        int elementToFind = inputLine[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(elementToFind)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }

    }
}
