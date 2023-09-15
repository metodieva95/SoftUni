package firstStepsInCoding;

import java.util.Scanner;

public class L07_ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int projectsCount = Integer.parseInt(scanner.nextLine());

        System.out.printf("The architect %s will need %d hours to complete %d project/s.",
                name, projectsCount * 3, projectsCount);
    }
}
