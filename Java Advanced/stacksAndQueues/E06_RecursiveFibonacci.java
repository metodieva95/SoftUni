package stacksAndQueues;

import java.util.Scanner;

public class E06_RecursiveFibonacci {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];

        System.out.println(getFibonacci(n));

    }

    public static long getFibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);

    }
}
