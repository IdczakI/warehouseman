package IdczakI.warehouseman.controller.receive;

import IdczakI.warehouseman.model.Product;
import IdczakI.warehouseman.model.ReceivedNote;
import IdczakI.warehouseman.model.Warehouseman;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ShowReceivedHistoryPaneController extends ReceivedNotePaneController {

    @FXML
    private TableView<ReceivedNote> receiveTableView;

    @FXML
    private TableColumn<ReceivedNote, String> dateTableColumn;

    @FXML
    private TableColumn<ReceivedNote, String> timeTableColumn;

    @FXML
    private TableColumn<ReceivedNote, String> productTableColumn;

    @FXML
    private TableColumn<ReceivedNote, String> qtyTableColumn;

    @FXML
    private TableColumn<ReceivedNote, String> palletsTableColumn;

    @FXML
    private TableColumn<ReceivedNote, String> warehousemanTableColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button productDetailsButton;

    @FXML
    private Button warehousemanDetailsButton;

    public void initialize() {
        fillTableView();
        searchTextField.setOnKeyTyped(this::searchReceivedHistory);
        productDetailsButton.setOnAction(this::getProductDetails);
        warehousemanDetailsButton.setOnAction(this::getWarehousemanDetails);
    }

    private void getWarehousemanDetails(ActionEvent event) {
        if (!receiveTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = receiveTableView.getSelectionModel().getSelectedIndex();
            String id = RECEIVED_NOTE_LIST.get(tableIndexForAll).getWarehousemanId();
            String firstName = RECEIVED_NOTE_LIST.get(tableIndexForAll).getWarehousemanFirstName();
            String lastName = RECEIVED_NOTE_LIST.get(tableIndexForAll).getWarehousemanLastName();
            detailWarehouseman = new Warehouseman(id, firstName, lastName);
            detailValue = 2;
            showPane("/fxml/control/getInfoPane.fxml", "Warehouseman Details");
        }
    }

    private void getProductDetails(ActionEvent event) {
        if (!receiveTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = receiveTableView.getSelectionModel().getSelectedIndex();
            String id = RECEIVED_NOTE_LIST.get(tableIndexForAll).getProductId();
            String description = RECEIVED_NOTE_LIST.get(tableIndexForAll).getProductDescription();
            int productsQty = Integer.parseInt(RECEIVED_NOTE_LIST.get(tableIndexForAll).getProductsQuantity());
            int palletsQty = Integer.parseInt(RECEIVED_NOTE_LIST.get(tableIndexForAll).getPalletsQuantity());
            int productsPerOnePallet = productsQty / palletsQty;
            detailProduct = new Product(id, description, productsPerOnePallet);
            detailValue = 1;
            showPane("/fxml/control/getInfoPane.fxml", "Product Details");
        }
    }

    private void fillTableView() {
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        productTableColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        qtyTableColumn.setCellValueFactory(new PropertyValueFactory<>("productsQuantity"));
        palletsTableColumn.setCellValueFactory(new PropertyValueFactory<>("palletsQuantity"));
        warehousemanTableColumn.setCellValueFactory(new PropertyValueFactory<>("warehousemanId"));
        receiveTableView.setItems(RECEIVED_NOTE_LIST);
    }

    private void searchReceivedHistory(KeyEvent event) {
        receiveTableView.setItems(ReceivedNote.getSearchedList(RECEIVED_NOTE_LIST, searchTextField.getText()));
    }
}
