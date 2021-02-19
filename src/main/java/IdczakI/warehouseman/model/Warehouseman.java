package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class Warehouseman {

    private String id;
    private String firstName;
    private String lastName;
    private String password;

    public Warehouseman(String id, String firstName, String lastName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id;
    }

    public String toCsv(){
        return id + Product.REGEX + firstName + Product.REGEX + lastName + Product.REGEX + password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouseman)) return false;
        Warehouseman that = (Warehouseman) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static ObservableList<Warehouseman> getSearchedList(ObservableList<Warehouseman> list, String s) {
        ObservableList<Warehouseman> tmpList = FXCollections.observableArrayList();
        list.stream()
                .filter(warehouseman -> warehouseman.getId().toLowerCase().contains(s.toLowerCase())
                        || warehouseman.getFirstName().toLowerCase().contains(s.toLowerCase())
                        || warehouseman.getLastName().toLowerCase().contains(s.toLowerCase())
                )
                .forEach(tmpList::add);
        return tmpList;
    }
}
