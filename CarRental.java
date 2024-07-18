package car_rental;

import java.util.Date;

public class CarRental {
	private String id;
	private Car car;
	private Customer customer;
	private Date rentalDate;
	private Date returnDate;
	private double totalCost;
	
	public CarRental(String id, Car car, Customer customer, Date rentalDate, Date returnDate, double totalCost) 
	{
		this.id = id;
		this.car = car;
		this.customer = customer;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.totalCost = totalCost;
		}
	public String getId() { return id; }
	public Car getCar() { return car; }
	public Customer getCustomer() { return customer; }
	public Date getRentalDate() { return rentalDate; }
	public Date getReturnDate() { return returnDate; }
	public double getTotalCost() { return totalCost; }
	
	public String toString() {
		return "Rental{" +
	"id='" + id + '\'' +
	", car=" + car +
	", customer=" + customer +
	", rentalDate=" + rentalDate +
	", returnDate=" + returnDate +
	", totalCost=" + totalCost +
	'}';
		}
	}


