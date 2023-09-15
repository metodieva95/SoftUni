package condutionalStatements;

import java.util.Scanner;

public class L07_AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figureType = scanner.nextLine();
        double sideLengthA = Double.parseDouble(scanner.nextLine());

        double area = 0;
        if (figureType.equals("square")) {
            area = sideLengthA * sideLengthA;
        } else if (figureType.equals("rectangle")) {
            double sideLengthB = Double.parseDouble(scanner.nextLine());
            area = sideLengthA * sideLengthB;
        } else if (figureType.equals("circle")) {
            area = Math.PI * sideLengthA * sideLengthA;
        } else if (figureType.equals("triangle")) {
            double height = Double.parseDouble(scanner.nextLine());
            area = sideLengthA * height / 2;
        }

        System.out.printf("%.3f", area);
    }
}
