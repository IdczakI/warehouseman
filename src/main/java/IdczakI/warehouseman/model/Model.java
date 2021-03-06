package IdczakI.warehouseman.model;

import IdczakI.warehouseman.io.IOFile;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static IdczakI.warehouseman.controller.MainController.loginWarehouseman;


public class Model {

    private int getProductQty(Inventory inventory) {
        return inventory.getPalletQty() * inventory.getProduct().getQuantityPerOnePallet();
    }

    public int getIntFromTextField(TextField textField) {
        boolean tmp = true;
        if (textField.getText().isEmpty() || textField.getText().length() > 5)
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

    public List<String> getNoteInfoList(ComboBox<Product> productComboBox, TextField intTextField) {
        return List.of(
                productComboBox.getValue().getId(),
                productComboBox.getValue().getDescription(),
                intTextField.getText(),
                String.valueOf
                        (Integer.parseInt(intTextField.getText()) * productComboBox.getValue().getQuantityPerOnePallet()),
                LocalDate.now().format(IOFile.DATE_FORMATTER),
                LocalTime.now().format(IOFile.TIME_FORMATTER),
                loginWarehouseman.getId(),
                loginWarehouseman.getFirstName(),
                loginWarehouseman.getLastName());
    }

}
