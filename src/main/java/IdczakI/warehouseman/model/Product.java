package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class Product {

    static final String REGEX = ",,";

    private String id;
    private String description;
    private int quantityPerOnePallet;

    public Product(String id, String description, int quantityPerOnePallet) {
        this.id = id;
        this.description = description;
        this.quantityPerOnePallet = quantityPerOnePallet;
    }

    public String getId() {
        return id;
    }

    public int getQuantityPerOnePallet() {
        return quantityPerOnePallet;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id.toLowerCase(), product.id.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static ObservableList<Product> getSearchedList(ObservableList<Product> list, String s) {
        ObservableList<Product> tmpList = FXCollections.observableArrayList();
        list.stream()
                .filter(product -> product.getId().toLowerCase().contains(s.toLowerCase()))
                .forEach(tmpList::add);
        return tmpList;
    }

    public String toCsv() {
        return id + REGEX + description + REGEX + quantityPerOnePallet;
    }

//    public static int getIntFromTextField(TextField textField) {
//        boolean tmp = true;
//        if (textField.getText().isEmpty())
//            return 0;
//        char[] chars = textField.getText().toCharArray();
//        for (char c : chars) {
//            if (!Character.isDigit(c)) {
//                tmp = false;
//                break;
//            }
//        }
//        return tmp ? Integer.parseInt(textField.getText()) : 0;
//    }
}
