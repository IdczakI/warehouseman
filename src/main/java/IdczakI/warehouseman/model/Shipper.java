package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class Shipper {

    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String vehicleRegistrationNumber;

    public Shipper(String id, String firstName, String lastName, String company, String vehicleRegistrationNumber) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shipper)) return false;
        Shipper shipper = (Shipper) o;
        return Objects.equals(id, shipper.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static ObservableList<Shipper> getSearchedList(ObservableList<Shipper> list, String s) {
        ObservableList<Shipper> tmpList = FXCollections.observableArrayList();
        list.stream()
                .filter(shipper -> shipper.getId().toLowerCase().contains(s.toLowerCase()))
                .forEach(tmpList::add);
        return tmpList;
    }
}
