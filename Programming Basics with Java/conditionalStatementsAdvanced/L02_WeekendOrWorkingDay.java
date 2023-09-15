package conditionalStatementsAdvanced;

import java.time.temporal.WeekFields;
import java.util.Scanner;

public class L02_WeekendOrWorkingDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String weekDay = scanner.nextLine();
        String typeOfDay = "";

        switch (weekDay) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                typeOfDay = "Working day";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                System.out.println("Error");
                break;
        }

        System.out.println(typeOfDay);
    }
}
