package examPrep17Oct2022.lootbox;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //FIFO -> Queue
        Deque<Integer> firstLootBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstLootBox::offer);

        //LIFO -> Stack
        Deque<Integer> secondLootBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondLootBox::push);

        int lootSum = 0;

       while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {

           int firstItem = firstLootBox.peek();
           int secondItem = secondLootBox.poll();

           int sum = firstItem + secondItem;

           if (sum % 2 == 0) {
              lootSum += sum;
               firstLootBox.poll();
           } else {
               firstLootBox.offer(secondItem);
           }
       }

       if (firstLootBox.isEmpty()) {
           System.out.println("First lootbox is empty");
       } else {
           System.out.println("Second lootbox is empty");
       }

       if (lootSum >= 100) {
           System.out.printf("Your loot was epic! Value: %d", lootSum);
       } else {
           System.out.printf("Your loot was poor... Value: %d", lootSum);
       }

    }

}

