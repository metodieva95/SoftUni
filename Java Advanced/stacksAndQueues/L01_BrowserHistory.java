package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();
        String currentURL = null;

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentURL = history.pop();
                }
            } else {
                if (currentURL != null) {
                    history.push(currentURL);
                }
                currentURL = input;
            }

            System.out.println(currentURL);
            input = scanner.nextLine();
        }

    }
}
