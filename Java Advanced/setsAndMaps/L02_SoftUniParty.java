package setsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class L02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> vip = new HashSet<>();
        Set<String> regular = new HashSet<>();

        while(!input.equals("PARTY")) {

            if (isFirstSymbolDigit(input)) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {

            if (isFirstSymbolDigit(input)) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        printReservation(vip);
        printReservation(regular);

    }

    private static boolean isFirstSymbolDigit(String input) {

        if (input.charAt(0) == '1' || input.charAt(0) == '2' || input.charAt(0) == '3' || input.charAt(0) == '4'
                || input.charAt(0) == '5' || input.charAt(0) == '6' || input.charAt(0) == '7'
                || input.charAt(0) == '8' || input.charAt(0) == '9' || input.charAt(0) == '0') {
            return true;
        }

        return false;
    }

    private static void printReservation(Set<String> reservation) {
        for (String r : reservation) {
            System.out.println(r);
        }
    }

}
