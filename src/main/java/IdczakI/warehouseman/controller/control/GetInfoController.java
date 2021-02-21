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
        return  "Product ID: " + immortalProduct.getId() + "\nProduct Description: " + immortalProduct.getDescription()
                + "\nQuantity per 1 Pallet: " + immortalProduct.getQuantityPerOnePallet();
    }

    public void initialize(){
        infoTextArea.setText(getReceivedHistoryText());
        okButton.setOnAction(event -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }
}
