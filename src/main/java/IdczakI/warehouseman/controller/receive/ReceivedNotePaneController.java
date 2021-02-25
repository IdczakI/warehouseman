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
        confirmReceiveButton.setOnAction(this::createReceivedNote);
        viewHistoryButton.setOnAction(event ->
                showPane("/fxml/receive/showReceivedHistoryPane.fxml", "Receive History"));
    }

    private void createReceivedNote(ActionEvent event) {
        if (productComboBox.getValue() == null) {
            shortProblemText = "You have to choose a product";
            showPane("/fxml/control/shortInfoPane.fxml", "Receive problem");
        } else if (model.getIntFromTextField(palletsQtyTextField) <= 0) {
            shortProblemText = "Pallets quantity must be\n integer greater than 0";
            showPane("/fxml/control/shortInfoPane.fxml", "Receive problem");
        }else  {
            List<String> infoList = model.getNoteInfoList(productComboBox,palletsQtyTextField);
            ReceivedNote receivedNote = new ReceivedNote(infoList.get(0), infoList.get(1), infoList.get(2),
                    infoList.get(3), infoList.get(4), infoList.get(5), infoList.get(6), infoList.get(7),
                    infoList.get(8));
            IOFile.RECEIVED_LIST.add(receivedNote);
            RECEIVED_NOTE_LIST.add(receivedNote);
            IOFile.INVENTORY_MAP.merge(productComboBox.getValue(),
                    Integer.valueOf(palletsQtyTextField.getText()), Integer::sum);
            fillInventoryDetailsList();
            palletsQtyTextField.clear();
        }
    }
}
