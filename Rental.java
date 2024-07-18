package car_rental;

import java.util.Date;

public class Rental {
    private String id;
    private Car car;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;

    public Rental(String id, Car car, Customer customer, Date rentalDate, Date returnDate) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        car.setAvailable(false); // Mark car as rented
    }

    // Getters and Setters
    // Getters
    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
