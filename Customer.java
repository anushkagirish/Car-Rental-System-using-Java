package car_rental;

public class Customer {
	private String id;
    private String name;
    private String drivingLicenseNumber;
    private String contactInfo;

    public Customer(String id, String name, String drivingLicenseNumber, String contactInfo) {
        this.id = id;
        this.name = name;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
 // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}


