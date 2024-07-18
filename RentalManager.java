package car_rental;

//RentalManager.java
import java.util.ArrayList;
import java.util.List;

public class RentalManager {
 private List<Rental> rentals = new ArrayList<>();

 public void createRental(Rental rental) {
     rentals.add(rental);
 }

 public void updateRental(String id, Rental updatedRental) {
     for (Rental rental : rentals) {
         if (rental.getId().equals(id)) {
             rental.setCar(updatedRental.getCar());
             rental.setCustomer(updatedRental.getCustomer());
             rental.setRentalDate(updatedRental.getRentalDate());
             rental.setReturnDate(updatedRental.getReturnDate());
             break;
         }
     }
 }

 public Rental getRental(String id) {
     for (Rental rental : rentals) {
         if (rental.getId().equals(id)) {
             return rental;
         }
     }
     return null;
 }

 public List<Rental> getAllRentals() {
     return rentals;
 }

 public void returnCar(String rentalId) {
     Rental rental = getRental(rentalId);
     if (rental != null) {
         rental.getCar().setAvailable(true); // Mark car as available
         rentals.remove(rental);
     }
 }

 public boolean isCarAvailable(String carId) {
     for (Rental rental : rentals) {
         if (rental.getCar().getId().equals(carId)) {
             return false;
         }
     }
     return true;
 }
}
