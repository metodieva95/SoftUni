package condutionalStatements;

import java.util.Scanner;

public class E08_LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seriesName = scanner.nextLine();
        int episodeTime = Integer.parseInt(scanner.nextLine());
        int breakTime = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakTime / 8.0;
        double restTime = breakTime / 4.0;

        double timeLeft = breakTime - lunchTime - restTime;
        double diff = Math.ceil(Math.abs(episodeTime - timeLeft));

        if (timeLeft >= episodeTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    seriesName, diff);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    seriesName, diff);
        }

    }
}
