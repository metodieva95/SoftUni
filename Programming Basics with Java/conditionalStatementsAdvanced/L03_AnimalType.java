package conditionalStatementsAdvanced;

import java.util.Scanner;

public class L03_AnimalType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animal = scanner.nextLine();
        String animalType = "";

        switch (animal) {
            case "dog":
                animalType = "mammal";
                break;
            case "crocodile":
            case "tortoise":
            case "snake":
                animalType = "reptile";
                break;
            default:
                System.out.println("unknown");
                break;
        }

        System.out.println(animalType);
    }
}
