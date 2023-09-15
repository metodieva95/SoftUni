package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L05_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque<String> printQueue = new ArrayDeque<>();

        while (!command.equals("print")) {

            if (command.equals("cancel")) {
                if (!printQueue.isEmpty()) {
                    System.out.printf("Canceled %s%n", printQueue.peek());
                    printQueue.poll();
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printQueue.offer(command);
            }

            command = scanner.nextLine();
        }

        for (String file : printQueue) {
            System.out.println(file);
        }
    }
}
