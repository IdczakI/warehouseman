package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReceivedNote {

    private String productId;
    private String productDescription;
    private String palletsQuantity;
    private String productsQuantity;
    private String date;
    private String time;
    private String warehousemanId;
    private String warehousemanFirstName;
    private String warehousemanLastName;

    public ReceivedNote(String productId, String productDescription, String palletsQuantity, String productsQuantity,
                        String date, String time, String warehousemanId, String warehousemanFirstName,
                        String warehousemanLastName) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.palletsQuantity = palletsQuantity;
        this.productsQuantity = productsQuantity;
        this.date = date;
        this.time = time;
        this.warehousemanId = warehousemanId;
        this.warehousemanFirstName = warehousemanFirstName;
        this.warehousemanLastName = warehousemanLastName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getPalletsQuantity() {
        return palletsQuantity;
    }

    public String getProductsQuantity() {
        return productsQuantity;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getWarehousemanId() {
        return warehousemanId;
    }

    public String getWarehousemanFirstName() {
        return warehousemanFirstName;
    }

    public String getWarehousemanLastName() {
        return warehousemanLastName;
    }

    @Override
    public String toString() {
        return productId + Product.REGEX + productDescription + Product.REGEX + palletsQuantity + Product.REGEX
                + productsQuantity + Product.REGEX + date + Product.REGEX + time + Product.REGEX + warehousemanId
                + Product.REGEX + warehousemanFirstName + Product.REGEX + warehousemanLastName;
    }

    public static ObservableList<ReceivedNote> getSearchedList(ObservableList<ReceivedNote> list, String s) {
        ObservableList<ReceivedNote> tmpList = FXCollections.observableArrayList();
        list.stream()
                .filter(r -> r.getDate().contains(s) || r.getProductId().toLowerCase().contains(s.toLowerCase())
                        || r.getWarehousemanId().toLowerCase().contains(s.toLowerCase())
                )
                .forEach(tmpList::add);
        return tmpList;
    }
}