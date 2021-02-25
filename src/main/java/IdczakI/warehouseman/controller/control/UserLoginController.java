package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.model.Warehouseman;
import javafx.event.ActionEvent;
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
        warehousemanPasswordField.setOnAction(this::checkPassword);
    }

    private void checkPassword(ActionEvent event) {
        if (idComboBox.getValue() == null){
            shortProblemText = "You have to choose a user";
            showPane("/fxml/control/shortInfoPane.fxml", "Login problem");
        }else if (warehousemanPasswordField.getText().equals(idComboBox.getValue().getPassword())) {
            loginWarehouseman = idComboBox.getValue();
            Stage stage = (Stage) idComboBox.getScene().getWindow();
            stage.close();
            showPane("/fxml/mainPane.fxml", "Warehouseman");
        } else {
            warehousemanPasswordField.clear();
            shortProblemText = "Wrong password";
            showPane("/fxml/control/shortInfoPane.fxml", "Wrong password");
        }
    }
}
