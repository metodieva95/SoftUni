package exam09aug2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //FIFO
        Deque<Integer> armour = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(armour::offer);

        //LIFO
        Deque<Integer> strikingImpact = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(strikingImpact::push);

        int countMonstersKilled = 0;

        while (!armour.isEmpty() && !strikingImpact.isEmpty()) {

            int currentArmour = armour.poll(); //20
            int currentStrikingImpact = strikingImpact.poll(); //25

            if (currentStrikingImpact >= currentArmour) { //25 > 20
                countMonstersKilled++;
                currentStrikingImpact = currentStrikingImpact - currentArmour; // 5

                if (currentStrikingImpact != 0) {
                    if (strikingImpact.size() > 1) {
                        int nextStrikingElement = strikingImpact.poll(); // 10
                        strikingImpact.push(currentStrikingImpact + nextStrikingElement); // 15
                    }
                }

            } else {

                currentArmour = currentArmour - currentStrikingImpact;
                armour.offer(currentArmour);
            }

        }

        if (armour.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", countMonstersKilled);


    }
}
