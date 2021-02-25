package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
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
        if (deleteValue.equals("S")) {
            IOFile.SHIPPER_MAP.remove(SHIPPER_LIST.get(tableIndexForAll).getId());
            SHIPPER_LIST.remove(tableIndexForAll);
        } else if (deleteValue.equals("P")) {
            if (IOFile.INVENTORY_MAP.containsKey(PRODUCT_LIST.get(tableIndexForAll))) {
                shortProblemText = "You cannot delete a product\nthat is in the inventory";
                showPane("/fxml/control/shortInfoPane.fxml", "Deleting problem");
            } else {
                IOFile.PRODUCT_MAP.remove(PRODUCT_LIST.get(tableIndexForAll).getId());
                PRODUCT_LIST.remove(tableIndexForAll);
            }
        }
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
}
