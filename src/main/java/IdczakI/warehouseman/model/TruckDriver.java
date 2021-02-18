package IdczakI.warehouseman.model;

public class TruckDriver {

    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String vehicleRegistrationNumber;

    public TruckDriver(String id, String firstName, String lastName, String company, String vehicleRegistrationNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    @Override
    public String toString() {
        return id + Product.REGEX + firstName + Product.REGEX + lastName + Product.REGEX
                + company + Product.REGEX + vehicleRegistrationNumber;
    }
}
