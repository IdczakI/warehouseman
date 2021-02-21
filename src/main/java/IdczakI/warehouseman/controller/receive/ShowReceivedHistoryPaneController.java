package IdczakI.warehouseman.controller.receive;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Product;
import IdczakI.warehouseman.model.ReceivedNote;
import IdczakI.warehouseman.model.Shipper;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

    public void initialize(){
        fillTableView();
        searchTextField.setOnKeyTyped(this::searchReceivedHistory);
        productDetailsButton.addEventFilter(ActionEvent.ACTION, event -> {
            if (!receiveTableView.getSelectionModel().isEmpty()) {
                int tableIndex = receiveTableView.getSelectionModel().getSelectedIndex();
                String id = RECEIVED_NOTE_LIST.get(tableIndex).getProductId();
                String description = RECEIVED_NOTE_LIST.get(tableIndex).getProductDescription();
                int productsQty = Integer.parseInt(RECEIVED_NOTE_LIST.get(tableIndex).getProductsQuantity());
                int palletsQty = Integer.parseInt(RECEIVED_NOTE_LIST.get(tableIndex).getPalletsQuantity());
                int productsPerOnePallet = productsQty / palletsQty;
                immortalProduct = new Product(id, description, productsPerOnePallet);
                showPane("/fxml/control/getInfoPane.fxml", "Product Details");
            }
        });
    }

    private void fillTableView() {
        RECEIVED_NOTE_LIST.clear();
        RECEIVED_NOTE_LIST.addAll(IOFile.RECEIVED_LIST);
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
