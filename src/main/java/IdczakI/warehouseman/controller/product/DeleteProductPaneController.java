package IdczakI.warehouseman.controller.product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteProductPaneController extends ProductPaneController {

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    public void initialize(){
        yesButton.setOnAction(this::deleteProduct);
        noButton.setOnAction(event -> closeWindow());
    }

    private void deleteProduct(ActionEvent event) {
        getProductsList().remove(tableIndexForEdit);
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
}
