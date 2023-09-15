package conditionalStatementsAdvanced;

import java.util.Scanner;

public class L12_TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double trades = Double.parseDouble(scanner.nextLine());

        double commission = 0;
        switch (city){
            case "Sofia":
                if (trades >= 0 && trades <= 500) {
                    commission = trades * 0.05;
                    System.out.printf("%.2f", commission);
                } else if (trades > 500 && trades <= 1000) {
                    commission = trades * 0.07;
                    System.out.printf("%.2f", commission);
                } else if (trades > 1000 && trades <= 10000){
                    commission = trades * 0.08;
                    System.out.printf("%.2f", commission);
                } else if (trades > 10000) {
                    commission = trades * 0.12;
                    System.out.printf("%.2f", commission);
                } else{
                    System.out.println("error");
                }
                break;
            case "Varna":
                if (trades >= 0 && trades <= 500) {
                    commission = trades * 0.045;
                    System.out.printf("%.2f", commission);
                } else if (trades > 500 && trades <= 1000) {
                    commission = trades * 0.075;
                    System.out.printf("%.2f", commission);
                } else if (trades > 1000 && trades <= 10000){
                    commission = trades * 0.1;
                    System.out.printf("%.2f", commission);
                } else if (trades > 10000) {
                    commission = trades * 0.13;
                    System.out.printf("%.2f", commission);
                }else{
                    System.out.println("error");
                }
                break;
            case "Plovdiv":
                if (trades >= 0 && trades <= 500) {
                    commission = trades * 0.055;
                    System.out.printf("%.2f", commission);
                } else if (trades > 500 && trades <= 1000) {
                    commission = trades * 0.08;
                    System.out.printf("%.2f", commission);
                } else if (trades > 1000 && trades <= 10000){
                    commission = trades * 0.12;
                    System.out.printf("%.2f", commission);
                } else if (trades > 10000) {
                    commission = trades * 0.145;
                    System.out.printf("%.2f", commission);
                }else{
                    System.out.println("error");
                }
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
