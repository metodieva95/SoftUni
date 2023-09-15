package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> playersQueue = new ArrayDeque<>();
        for (String player : players) {
            playersQueue.offer(player);
        }

        int cycle = 1;
        while (playersQueue.size() > 1) {
            for (int i = 1; i < num; i++) {
                playersQueue.offer(playersQueue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + playersQueue.peek());
            } else {
                System.out.println("Removed " + playersQueue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + playersQueue.peek());
    }

    static boolean isPrime (int n) {
        if(n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2 ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
