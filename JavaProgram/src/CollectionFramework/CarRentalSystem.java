package CollectionFramework;

import java.util.ArrayList;
import java.util.Scanner;

class Car {
    int carId;
    String brand;
    double rentPerDay;
    boolean isAvailable;

    Car(int carId, String brand, double rentPerDay) {
        this.carId = carId;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
    }
}

class Customer {
    int customerId;
    String name;

    Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
}

class Rental {
    Car car;
    Customer customer;
    int days;

    Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }
}

public class CarRentalSystem {

    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cars.add(new Car(1, "Hyundai", 1500));
        cars.add(new Car(2, "Toyota", 2000));
        cars.add(new Car(3, "Honda", 1800));

        int choice;

        do {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent Car");
            System.out.println("3. Return Car");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showAvailableCars();
                    break;

                case 2:
                    rentCar();
                    break;

                case 3:
                    returnCar();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // Display available cars
    static void showAvailableCars() {

        System.out.println("\nAvailable Cars:");

        boolean found = false;

        for (Car car : cars) {
            if (car.isAvailable) {
                System.out.println(car.carId + " - " + car.brand + " - Rs."+ car.rentPerDay + "/day");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No Cars Available!");
        }
    }

    // Rent a car
    static void rentCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        for (Car car : cars) {

            if (car.carId == id && car.isAvailable) {

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Number of Days: ");
                int days = sc.nextInt();

                if (days <= 0) {
                    System.out.println("Enter valid number of days!");
                    return;
                }

                Customer customer = new Customer(rentals.size() + 1, name);

                Rental rental = new Rental(car, customer, days);

                rentals.add(rental);

                car.isAvailable = false;

                double total = days * car.rentPerDay;

                System.out.println("Car Rented Successfully!");
                System.out.println("Customer Name: " + name);
                System.out.println("Car Brand: " + car.brand);
                System.out.println("Total Cost: Rs." + total);

                return;
            }
        }

        System.out.println("Car Not Available or Invalid Car ID!");
    }

    // Return a car
    static void returnCar() {

        System.out.print("Enter Car ID to Return: ");
        int id = sc.nextInt();

        for (Rental rental : rentals) {

            if (rental.car.carId == id) {

                rental.car.isAvailable = true;

                rentals.remove(rental);

                System.out.println("Car Returned Successfully!");

                return;
            }
        }

        System.out.println("Invalid Car ID!");
    }
}
