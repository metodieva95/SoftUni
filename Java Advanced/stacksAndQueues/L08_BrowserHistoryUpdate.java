package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L08_BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String currentURL = null;
        String forwardURL = null;

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (history.size() < 2) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentURL = history.pop();
                    forward.push(currentURL);
                    System.out.println(history.peek());
                }
            } else if (input.equals("forward")){

                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    forwardURL = forward.pop();
                    history.push(forwardURL);
                    System.out.println(forwardURL);
                }
            } else {
                history.push(input);
                System.out.println(input);
                forward.clear();
            }

            input = scanner.nextLine();
        }

    }
}
