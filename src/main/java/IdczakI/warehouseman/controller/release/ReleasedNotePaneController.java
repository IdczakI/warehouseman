package IdczakI.warehouseman.controller.release;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;

public class ReleasedNotePaneController extends MainController {

    Model model = new Model();

    @FXML
    private Button confirmReleaseButton;

    @FXML
    private ComboBox<Product> productComboBox;

    @FXML
    private ComboBox<Shipper> shipperComboBox;

    @FXML
    private TextField palletsQtyTextField;

    @FXML
    private Button viewHistoryButton;

    public void initialize() {
        productComboBox.setItems(PRODUCT_LIST);
        shipperComboBox.setItems(SHIPPER_LIST);
        confirmReleaseButton.setOnAction(this::createReleasedNote);
        viewHistoryButton.setOnAction(event ->
                showPane("/fxml/release/showReleasedHistoryPane.fxml", "Release History"));
    }

    private void createReleasedNote(ActionEvent event) {
        if (productComboBox.getValue() == null) {
            shortProblemText = "You have to choose a product";
            showPane("/fxml/control/shortInfoPane.fxml", "Release problem");
        } else if (shipperComboBox.getValue() == null) {
            shortProblemText = "You have to choose a shipper";
            showPane("/fxml/control/shortInfoPane.fxml", "Release problem");
        } else if (IOFile.INVENTORY_MAP.get(productComboBox.getValue()) == null) {
            shortProblemText = "This product is not in the stock";
            showPane("/fxml/control/shortInfoPane.fxml", "Release problem");
        } else if (model.getIntFromTextField(palletsQtyTextField) <= 0) {
            shortProblemText = "Pallets quantity must be\n integer greater than 0";
            showPane("/fxml/control/shortInfoPane.fxml", "Release problem");
        } else if (IOFile.INVENTORY_MAP.get(productComboBox.getValue())
                < Integer.parseInt(palletsQtyTextField.getText())) {
            shortProblemText = "There are not as many pallets\n of this product in the stock";
            showPane("/fxml/control/shortInfoPane.fxml", "Release problem");
        } else {
            String id = shipperComboBox.getValue().getId();
            String firstName = shipperComboBox.getValue().getFirstName();
            String lastName = shipperComboBox.getValue().getLastName();
            String company = shipperComboBox.getValue().getCompany();
            String vehicle = shipperComboBox.getValue().getVehicleRegistrationNumber();
            List<String> infoList = model.getNoteInfoList(productComboBox, palletsQtyTextField);
            ReleaseNote releaseNote = new ReleaseNote(infoList.get(0), infoList.get(1), infoList.get(2),
                    infoList.get(3), infoList.get(4), infoList.get(5), infoList.get(6), infoList.get(7),
                    infoList.get(8), id, firstName, lastName, company, vehicle);
            IOFile.RELEASE_LIST.add(releaseNote);
            RELEASE_NOTE_LIST.add(releaseNote);
            IOFile.INVENTORY_MAP.merge(productComboBox.getValue(), Integer.valueOf(palletsQtyTextField.getText()),
                    (prevValue, updateValue) -> prevValue - updateValue);
            if (IOFile.INVENTORY_MAP.get(productComboBox.getValue()) <= 0)
                IOFile.INVENTORY_MAP.remove(productComboBox.getValue());
            fillInventoryDetailsList();
            palletsQtyTextField.clear();
        }
    }
}
