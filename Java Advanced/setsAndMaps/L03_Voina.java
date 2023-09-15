package setsAndMaps;

import java.util.*;

public class L03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstPlayerSet = new LinkedHashSet<>();
        fillInPlayerSet(numbers, firstPlayerSet);

        numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> secondPlayerSet = new LinkedHashSet<>();
        fillInPlayerSet(numbers, secondPlayerSet);

       int roundsCount = 0;
       while (roundsCount < 50 && !firstPlayerSet.isEmpty() && !secondPlayerSet.isEmpty()) {

           int firstPlayerCard = firstPlayerSet.iterator().next();
           firstPlayerSet.remove(firstPlayerCard);
           int secondPlayerCard = secondPlayerSet.iterator().next();
           secondPlayerSet.remove(secondPlayerCard);

           checkBiggerCard(firstPlayerSet, secondPlayerSet, firstPlayerCard, secondPlayerCard);

           roundsCount++;
       }

        printWinner(firstPlayerSet, secondPlayerSet);

    }

    private static void fillInPlayerSet(int[] numbers, Set<Integer> playerSet) {
        for (int num : numbers) {
            playerSet.add(num);
        }
    }

    private static void checkBiggerCard(Set<Integer> firstPlayerSet, Set<Integer> secondPlayerSet, int firstPlayerCard, int secondPlayerCard) {
        if (firstPlayerCard > secondPlayerCard) {
            firstPlayerSet.add(firstPlayerCard);
            firstPlayerSet.add(secondPlayerCard);
        } else if (secondPlayerCard > firstPlayerCard) {
            secondPlayerSet.add(firstPlayerCard);
            secondPlayerSet.add(secondPlayerCard);
        }
    }

    private static void printWinner(Set<Integer> firstPlayerSet, Set<Integer> secondPlayerSet) {
        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerSet.size() > firstPlayerSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
