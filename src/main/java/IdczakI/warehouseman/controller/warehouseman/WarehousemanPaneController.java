package IdczakI.warehouseman.controller.warehouseman;

import IdczakI.warehouseman.controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class WarehousemanPaneController extends MainController {

    @FXML
    private Button logOutButton;

    @FXML
    private TextArea userInfoTextArea;

    private String getUserInfoText() {
        return "User Info:\nWarehouseman ID: " + loginWarehouseman.getId()
                + "\nWarehouseman first name: " + loginWarehouseman.getFirstName() + "\nWarehouseman last name: "
                + loginWarehouseman.getLastName();
    }

    public void initialize(){
        userInfoTextArea.setText(getUserInfoText());
        logOutButton.setOnAction(this::logOut);
    }

    private void logOut(ActionEvent event) {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();
        showPane("/fxml/control/userLoginPane.fxml", "Warehouseman login");
    }
}
