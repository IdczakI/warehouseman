package IdczakI.warehouseman.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.util.Map;

public class Model {

    public ObservableList<InventoryNew> createInventoryNewList(Map<String, Inventory> inventoryMap) {
        ObservableList<InventoryNew> tmpList = FXCollections.observableArrayList();
        inventoryMap.values().stream()
                .map(inventory -> new InventoryNew(inventory.getProduct().getId(),
                        inventory.getProduct().getDescription(),
                        getProductQty(inventory),
                        inventory.getQuantityOfPallets()))
                .forEach(tmpList::add);
        return tmpList;
    }

    private int getProductQty(Inventory inventory) {
        return  inventory.getQuantityOfPallets() * inventory.getProduct().getQuantityPerOnePallet();
    }

    public int getIntFromTextField(TextField textField) {
        boolean tmp = true;
        if (textField.getText().isEmpty() || textField.getText().length() > 6)
            return 0;
        char[] chars = textField.getText().toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                tmp = false;
                break;
            }
        }
        return tmp ? Integer.parseInt(textField.getText()) : 0;
    }
}
