package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteController extends MainController {

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    public void initialize() {
        yesButton.setOnAction(this::deleteProduct);
        noButton.setOnAction(event -> closeWindow());
    }

    private void deleteProduct(ActionEvent event) {
        if (deleteValue.equals("S"))
            getShippersList().remove(getTableIndexForEdit());
        else if (deleteValue.equals("P"))
            getProductsList().remove(getTableIndexForEdit());
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
}
