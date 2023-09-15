package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01_ReverseNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersStack.push(numbers[i]);
        }

        for (Integer num : numbersStack) {
            System.out.print(num + " ");
        }
    }
}
