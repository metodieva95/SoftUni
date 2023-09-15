package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E03_MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int command = line[0];

            switch (command) {
                case 1:
                    int num = line[1];
                    numbers.push(num);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }

    }
}