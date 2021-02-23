package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GetInfoController extends MainController {

    @FXML
    private TextArea infoTextArea;

    @FXML
    private Button okButton;

    private String getReceivedHistoryText() {
        if (detailValue == 1)
            return "Product: " + detailProduct.getId() + "\n\n" + detailProduct.getDescription()
                    + "\n\nQuantity per 1 Pallet: " + detailProduct.getQuantityPerOnePallet();
        else if (detailValue == 2)
            return "Warehouseman:\n" + detailWarehouseman.getFirstName() + " " + detailWarehouseman.getLastName()
                    + "\nID: " + detailWarehouseman.getId();
        else if (detailValue == 3)
            return "Shipper ID:\n" + detailShipper.getId() + "\nCompany:\n" + detailShipper.getCompany()
                    + "\nTruck Driver:\n" + detailShipper.getFirstName() + " " + detailShipper.getLastName()
                    + "\nVehicle Number:\n" + detailShipper.getVehicleRegistrationNumber();
        else return "No option was selected";
    }

    public void initialize() {
        infoTextArea.setText(getReceivedHistoryText());
        okButton.setOnAction(event -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }
}
