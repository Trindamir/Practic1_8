/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practic18;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class enikeev {
    public static void main(String[] args) {
        System.out.println("Вариант 1. Еникеев Дамир Илмирович");
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Volvo s90", 2015, "x001xx"));
        carList.add(new Car("Lada Vesta", 2020, "x002xx"));
        carList.add(new Car("Kia Rio", 2012, "x003xx"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new car");
            System.out.println("2. Delete the car by number");
            System.out.println("3. Delete all cars");
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.println("Car's brand: ");
                    String brand = scanner.nextLine();
                    System.out.println("Year: ");
                    int year = 0;
                    while (true) {
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                            if (year >= 1900 && year <= currentYear) {
                                break;
                            } else {
                                System.out.println("Type in the correct year(from 1900 to " + currentYear + ").");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Type in the correct year in number format.");
                        }
                    }

                    System.out.println("Type in the registration number ");
                    String regNumber = scanner.nextLine();

                    Car newCar = new Car(brand, year, regNumber);
                    if (!carList.contains(newCar)) {
                        carList.add(newCar);
                        System.out.println("The car is successfully added");
                    } else {
                        System.out.println("The car with that registration number already exists.");
                    }
                }

                case 2 -> {
                    System.out.println("Type in the registration number of a car you want to delete: ");
                    String regNumToRemove = scanner.nextLine();

                    Iterator<Car> iterator = carList.iterator();
                    while (iterator.hasNext()) {
                        Car car = iterator.next();
                        if (car.regNumber.equals(regNumToRemove)) {
                            iterator.remove();
                            System.out.println("The car is successfully deleted");
                        }
                    }
                }

                case 3 -> {
                    carList.clear();
                    System.out.println("All cars are cleared");
                }

                default -> System.out.println("Incorrect choice, try again.");
            }

            System.out.println("Current list of cars: ");
            for (Car car : carList) {
                System.out.println(car);
            }
        }
    }
}
