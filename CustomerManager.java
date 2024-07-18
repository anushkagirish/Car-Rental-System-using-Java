package car_rental;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void updateCustomer(String id, Customer updatedCustomer) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setName(updatedCustomer.getName());
                customer.setDrivingLicenseNumber(updatedCustomer.getDrivingLicenseNumber());
                customer.setContactInfo(updatedCustomer.getContactInfo());
                break;
            }
        }
    }

    public void deleteCustomer(String id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }

    public Customer getCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}