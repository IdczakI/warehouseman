package IdczakI.warehouseman.model;

public class Warehouseman {

    private String id;
    private String firstName;
    private String lastName;

    public Warehouseman(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + Product.REGEX + firstName + Product.REGEX + lastName;
    }
}
