package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.model.Warehouseman;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class UserLoginController extends MainController {

    @FXML
    private PasswordField warehousemanPasswordField;

    @FXML
    private ComboBox<Warehouseman> idComboBox;

    public void initialize() {
        idComboBox.setItems(WAREHOUSEMAN_LIST);
        idComboBox.setValue(WAREHOUSEMAN_LIST.get(0));
        warehousemanPasswordField.setOnAction(event -> {
            if (warehousemanPasswordField.getText().equals(idComboBox.getValue().getPassword())) {
                loginWarehouseman = idComboBox.getValue();
                showPane("/fxml/mainPane.fxml", "Warehouseman");
                Stage stage = (Stage) idComboBox.getScene().getWindow();
                stage.close();
            } else {
                warehousemanPasswordField.clear();
                shortProblemText = "Wrong password";
                showPane("/fxml/control/shortInfoPane.fxml", "Wrong password");
            }
        });


    }
}
