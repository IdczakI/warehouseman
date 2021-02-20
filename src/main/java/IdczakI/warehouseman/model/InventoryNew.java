package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryNew {

    private String productId;
    private String productDescription;
    private int productQty;
    private int palletQty;

    public InventoryNew(String productId, String productDescription, int productQty, int palletQty) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.productQty = productQty;
        this.palletQty = palletQty;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductQty() {
        return productQty;
    }

    public int getPalletQty() {
        return palletQty;
    }

    public static ObservableList<InventoryNew> getSearchedList(ObservableList<InventoryNew> list, String s) {
        ObservableList<InventoryNew> tmpList = FXCollections.observableArrayList();
        list.stream()
                .filter(inv -> inv.getProductId().toLowerCase().contains(s.toLowerCase()))
                .forEach(tmpList::add);
        return tmpList;
    }
}
