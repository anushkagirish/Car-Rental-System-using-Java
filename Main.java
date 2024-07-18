package car_rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CarManager carManager = new CarManager();
    private static CustomerManager customerManager = new CustomerManager();
    private static RentalManager rentalManager = new RentalManager();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Car Rental System");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return a Car");
            System.out.println("5. List all Cars");
            System.out.println("6. List all Customers");
            System.out.println("7. List all Rentals");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCar(scanner);
                    break;
                case 2:
                    addCustomer(scanner);
                    break;
                case 3:
                    rentCar(scanner);
                    break;
                case 4:
                    returnCar(scanner);
                    break;
                case 5:
                    listAllCars();
                    break;
                case 6:
                    listAllCustomers();
                    break;
                case 7:
                    listAllRentals();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void addCar(Scanner scanner) {
        System.out.print("Enter Car ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Car car = new Car(id, make, model, year);
        carManager.addCar(car);
        System.out.println("Car added successfully.");
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Driving License Number: ");
        String drivingLicenseNumber = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        Customer customer = new Customer(id, name, drivingLicenseNumber, contactInfo);
        customerManager.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private static void rentCar(Scanner scanner) {
        System.out.print("Enter Rental ID: ");
        String rentalId = scanner.nextLine();
        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Rental Date (yyyy-MM-dd): ");
        String rentalDateStr = scanner.nextLine();
        System.out.print("Enter Return Date (yyyy-MM-dd): ");
        String returnDateStr = scanner.nextLine();

        Car car = carManager.getCar(carId);
        if (car == null || !car.isAvailable()) {
            System.out.println("Car not available or doesn't exist.");
            return;
        }

        Customer customer = customerManager.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer doesn't exist.");
            return;
        }

        Date rentalDate = null;
        Date returnDate = null;
        try {
            rentalDate = dateFormat.parse(rentalDateStr);
            returnDate = dateFormat.parse(returnDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        Rental rental = new Rental(rentalId, car, customer, rentalDate, returnDate);
        rentalManager.createRental(rental);
        System.out.println("Car rented successfully.");
    }

    private static void returnCar(Scanner scanner) {
        System.out.print("Enter Rental ID: ");
        String rentalId = scanner.nextLine();
        Rental rental = rentalManager.getRental(rentalId);
        if (rental != null) {
            rental.getCar().setAvailable(true);
            rentalManager.returnCar(rentalId);
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Rental ID not found.");
        }
    }

    private static void listAllCars() {
        List<Car> cars = carManager.getAllCars();
        for (Car car : cars) {
            System.out.println("ID: " + car.getId() + ", Make: " + car.getMake() + ", Model: " + car.getModel() + ", Year: " + car.getYear() + ", Available: " + car.isAvailable());
        }
    }

    private static void listAllCustomers() {
        List<Customer> customers = customerManager.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() + ", Driving License Number: " + customer.getDrivingLicenseNumber() + ", Contact Info: " + customer.getContactInfo());
        }
    }

    private static void listAllRentals() {
        List<Rental> rentals = rentalManager.getAllRentals();
        for (Rental rental : rentals) {
            System.out.println("Rental ID: " + rental.getId() + ", Car ID: " + rental.getCar().getId() + ", Customer ID: " + rental.getCustomer().getId() + ", Rental Date: " + rental.getRentalDate() + ", Return Date: " + rental.getReturnDate());
        }
    }
}
