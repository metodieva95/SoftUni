package conditionalStatementsAdvanced;

import java.util.Scanner;

public class E01_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int rowCount = Integer.parseInt(scanner.nextLine());
        int columnCount = Integer.parseInt(scanner.nextLine());

        double income = 0;

        if (type.equals("Premiere")) {
            income = rowCount * columnCount * 12;
        } else if (type.equals("Normal")) {
            income = rowCount * columnCount * 7.5;
        } else if (type.equals("Discount")) {
            income = rowCount * columnCount * 5;
        }

        System.out.printf("%.2f leva", income);
    }
}
