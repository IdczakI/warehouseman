package IdczakI.warehouseman.controller.shipper;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Shipper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddShipperPaneController extends ShipperPaneController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField vehicleNumberTextField;

    @FXML
    private TextField companyTextField;

    @FXML
    private Button addShipperButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    public void initialize() {
        addShipperButton.setOnAction(this::productButton);
    }

    private void productButton(ActionEvent event) {
        Shipper shipper = new Shipper(idTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(),
                companyTextField.getText(), vehicleNumberTextField.getText());
        if (!IOFile.SHIPPER_MAP.containsKey(shipper.getId())) {
            SHIPPER_LIST.add(shipper);
            IOFile.SHIPPER_MAP.put(shipper.getId(), shipper);
        }
        Stage stage = (Stage) addShipperButton.getScene().getWindow();
        stage.close();
    }
}
