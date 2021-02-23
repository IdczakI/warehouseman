package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReleaseNote {

    private String productId;
    private String productDescription;
    private String palletsQuantity;
    private String productsQuantity;
    private String date;
    private String time;
    private String warehousemanId;
    private String warehousemanFirstName;
    private String warehousemanLastName;
    private String shipperId;
    private String shipperFirstName;
    private String shipperLastName;
    private String shipperCompany;
    private String vehicleRegistrationNumber;

    public ReleaseNote(String productId, String productDescription, String palletsQuantity, String productsQuantity,
                       String date, String time, String warehousemanId, String warehousemanFirstName,
                       String warehousemanLastName, String shipperId, String shipperFirstName, String shipperLastName,
                       String shipperCompany, String vehicleRegistrationNumber) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.palletsQuantity = palletsQuantity;
        this.productsQuantity = productsQuantity;
        this.date = date;
        this.time = time;
        this.warehousemanId = warehousemanId;
        this.warehousemanFirstName = warehousemanFirstName;
        this.warehousemanLastName = warehousemanLastName;
        this.shipperId = shipperId;
        this.shipperFirstName = shipperFirstName;
        this.shipperLastName = shipperLastName;
        this.shipperCompany = shipperCompany;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;


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

    public String getShipperId() {
        return shipperId;
    }

    public String getShipperFirstName() {
        return shipperFirstName;
    }

    public String getShipperLastName() {
        return shipperLastName;
    }

    public String getShipperCompany() {
        return shipperCompany;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    @Override
    public String toString() {
        return productId + Product.REGEX + productDescription + Product.REGEX + palletsQuantity + Product.REGEX
                + productsQuantity + Product.REGEX + date + Product.REGEX + time + Product.REGEX + warehousemanId
                + Product.REGEX + warehousemanFirstName + Product.REGEX + warehousemanLastName + Product.REGEX
                + shipperId + Product.REGEX + shipperFirstName + Product.REGEX  + shipperLastName + Product.REGEX
                + shipperCompany + Product.REGEX + vehicleRegistrationNumber;
    }

    public static ObservableList<ReleaseNote> getSearchedList(ObservableList<ReleaseNote> list, String s) {
        ObservableList<ReleaseNote> tmpList = FXCollections.observableArrayList();
        list.stream()
                .filter(r -> r.getDate().contains(s) || r.getProductId().toLowerCase().contains(s.toLowerCase())
                        || r.getWarehousemanId().toLowerCase().contains(s.toLowerCase())
                        || r.getShipperId().toLowerCase().contains(s.toLowerCase())
                )
                .forEach(tmpList::add);
        return tmpList;
    }
}
