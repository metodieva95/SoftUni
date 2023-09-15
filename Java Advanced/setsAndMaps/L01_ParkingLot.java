package setsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Set<String> carNumbers = new LinkedHashSet<>();

        while(!input[0].equals("END")) {

            String direction = input[0];
            String carNumber = input[1];

            manipulateCurrentCar(carNumbers, direction, carNumber);

            input = scanner.nextLine().split(", ");
        }

        printCars(carNumbers);
    }

    private static void manipulateCurrentCar(Set<String> carNumbers, String direction, String carNumber) {
        switch (direction) {
            case "IN":
                carNumbers.add(carNumber);
                break;
            case "OUT":
                carNumbers.remove(carNumber);
                break;
        }
    }

    private static void printCars(Set<String> carNumbers) {
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
