package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ShortInfoController extends MainController {

    @FXML
    private Button okButton;

    @FXML
    private Label infoLabel;

    public void initialize(){
        infoLabel.setText("Wrong password");
        okButton.setOnAction(event -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }

}
