package IdczakI.warehouseman.controller.shipper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteShipperPaneController extends ShipperPaneController{

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    public void initialize(){
        yesButton.setOnAction(this::deleteProduct);
        noButton.setOnAction(event -> closeWindow());
    }

    private void deleteProduct(ActionEvent event) {
        getShippersList().remove(getTableIndexForEdit());
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
}
