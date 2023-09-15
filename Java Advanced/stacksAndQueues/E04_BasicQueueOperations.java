package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToAdd = inputLine[0];
        int elementsToPoll = inputLine[1];
        int elementToFind = inputLine[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elementsToAdd; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < elementsToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementToFind)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
