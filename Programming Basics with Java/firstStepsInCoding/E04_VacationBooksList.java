package firstStepsInCoding;

import java.util.Scanner;

public class E04_VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pagesCount = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine()); // his reading speed
        int days = Integer.parseInt(scanner.nextLine()); // how many days he has to read the book

        int totalHoursNeeded = pagesCount / pagesPerHour;
        int hoursPerDay = totalHoursNeeded / days;

        System.out.println(hoursPerDay);
    }
}
