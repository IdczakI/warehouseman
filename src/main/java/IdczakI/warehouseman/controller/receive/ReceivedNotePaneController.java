package IdczakI.warehouseman.controller.receive;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.ReceivedNote;
import IdczakI.warehouseman.model.Model;
import IdczakI.warehouseman.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;

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
        productComboBox.setItems(PRODUCTS_LIST);
        productComboBox.setValue(PRODUCTS_LIST.get(0));
        confirmReceiveButton.setOnAction(this::createReceivedNote);
        viewHistoryButton.setOnAction(event ->
                showPane("/fxml/receive/showReceivedHistoryPane.fxml", "Receive History"));
    }

    private void createReceivedNote(ActionEvent event) {
        if (model.getIntFromTextField(palletsQtyTextField) > 0) {
            String productId = productComboBox.getValue().getId();
            String productDescription = productComboBox.getValue().getDescription();
            String palletsQuantity = palletsQtyTextField.getText();
            String  productsQuantity = String.valueOf
                    (Integer.parseInt(palletsQuantity) * productComboBox.getValue().getQuantityPerOnePallet());
            String date = LocalDate.now().format(IOFile.DATE_FORMATTER);
            String time = LocalTime.now().format(IOFile.TIME_FORMATTER);
            String warehousemanId = loginWarehouseman.getId();
            String warehousemanFirstName = loginWarehouseman.getFirstName();
            String warehousemanLastName = loginWarehouseman.getLastName();
            IOFile.RECEIVED_LIST.add(new ReceivedNote(productId, productDescription, palletsQuantity,
                    productsQuantity, date, time, warehousemanId, warehousemanFirstName, warehousemanLastName));
            palletsQtyTextField.clear();
        }
    }
}
