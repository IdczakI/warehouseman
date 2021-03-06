package IdczakI.warehouseman.controller.shipper;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Shipper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditShipperControlPane extends ShipperPaneController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField vehicleNumberTextField;

    @FXML
    private TextField companyTextField;

    @FXML
    private Button editShipperButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;


    public void initialize() {
        fillTextFields();
        editShipperButton.setOnAction(this::editProduct);
    }

    private void editProduct(ActionEvent event) {
        Shipper shipper = new Shipper(shipperForEdit.getId(), firstNameTextField.getText(), lastNameTextField.getText(),
                companyTextField.getText(), vehicleNumberTextField.getText());
        SHIPPER_LIST.set(tableIndexForAll, shipper);
        IOFile.SHIPPER_MAP.merge(shipper.getId(), shipper, (shipper1, shipper2) -> shipper2);
        Stage stage = (Stage) editShipperButton.getScene().getWindow();
        stage.close();
    }

    private void fillTextFields() {
        idTextField.setText(shipperForEdit.getId());
        vehicleNumberTextField.setText(shipperForEdit.getVehicleRegistrationNumber());
        firstNameTextField.setText(shipperForEdit.getFirstName());
        lastNameTextField.setText(shipperForEdit.getLastName());
        companyTextField.setText(shipperForEdit.getCompany());
    }
}
