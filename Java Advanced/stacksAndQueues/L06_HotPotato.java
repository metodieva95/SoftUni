package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int countToss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < countToss; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }
            System.out.printf("Removed %s%n", childrenQueue.poll());
        }

        System.out.printf("Last is %s", childrenQueue.poll());

    }
}
