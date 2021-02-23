package IdczakI.warehouseman.controller.receive;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Model;
import IdczakI.warehouseman.model.Product;
import IdczakI.warehouseman.model.ReceivedNote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;

public class ReceivedNotePaneController extends MainController {

    Model model = new Model();

    @FXML
    private Button confirmReceiveButton;

    @FXML
    private ComboBox<Product> productComboBox;

    @FXML
    private TextField palletsQtyTextField;

    @FXML
    private Button viewHistoryButton;

    public void initialize() {
        productComboBox.setItems(PRODUCT_LIST);
        productComboBox.setValue(PRODUCT_LIST.get(0));
        confirmReceiveButton.setOnAction(this::createReceivedNote);
        viewHistoryButton.setOnAction(event ->
                showPane("/fxml/receive/showReceivedHistoryPane.fxml", "Receive History"));
    }

    private void createReceivedNote(ActionEvent event) {
        if (model.getIntFromTextField(palletsQtyTextField) > 0) {
            List<String> infoList = model.getNoteInfoList(productComboBox,palletsQtyTextField);
            IOFile.RECEIVED_LIST.add(new ReceivedNote(infoList.get(0), infoList.get(1), infoList.get(2),
                    infoList.get(3), infoList.get(4), infoList.get(5), infoList.get(6), infoList.get(7),
                    infoList.get(8)));
            palletsQtyTextField.clear();
        }
    }
}
