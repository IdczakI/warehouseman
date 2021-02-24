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
        productComboBox.setValue(PRODUCT_LIST.get(0));
        shipperComboBox.setItems(SHIPPER_LIST);
        shipperComboBox.setValue(SHIPPER_LIST.get(0));
        confirmReleaseButton.setOnAction(this::createReleasedNote);
        viewHistoryButton.setOnAction(event ->
                showPane("/fxml/release/showReleasedHistoryPane.fxml", "Release History"));
    }

    private void createReleasedNote(ActionEvent event) {
        if (model.getIntFromTextField(palletsQtyTextField) > 0) {
            if (IOFile.INVENTORY_MAP.get(productComboBox.getValue()) >= Integer.parseInt(palletsQtyTextField.getText())) {
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
                fillInventoryDetailsList();
                palletsQtyTextField.clear();
            }else {
                shortProblemText = "The is not that many pallets ot this item";
                showPane("/fxml/control/shortInfoPane.fxml", "Release problem");
            }
        }
    }
}
