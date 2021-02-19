package IdczakI.warehouseman.controller.control;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Warehouseman;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;

public class WarehousemanLoginController extends MainController {

    @FXML
    private PasswordField warehousemanPasswordField;

    @FXML
    private ChoiceBox<Warehouseman> idChoiceBox;

    @FXML
    private Button myButton;

    public void initialize(){
       WAREHOUSEMAN_LIST.addAll(IOFile.WAREHOUSEMAN_MAP.values());
       idChoiceBox.setItems(WAREHOUSEMAN_LIST);
       idChoiceBox.setOnAction(event -> {
           int selectedIndex = idChoiceBox.getSelectionModel().getSelectedIndex();
           Warehouseman warehouseman = idChoiceBox.getSelectionModel().getSelectedItem();
           System.out.println(warehouseman.toString());
       });
       warehousemanPasswordField.setOnAction(event -> {
           System.out.println(warehousemanPasswordField.getText());
           if (warehousemanPasswordField.getText().equals(idChoiceBox.getSelectionModel().getSelectedItem().getPassword()))
           System.out.println("tak");
       });



    }
}
