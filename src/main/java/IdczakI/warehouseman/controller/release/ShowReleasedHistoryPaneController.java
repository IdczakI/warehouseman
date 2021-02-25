package IdczakI.warehouseman.controller.release;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.model.Product;
import IdczakI.warehouseman.model.ReleaseNote;
import IdczakI.warehouseman.model.Shipper;
import IdczakI.warehouseman.model.Warehouseman;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ShowReleasedHistoryPaneController extends MainController {

    @FXML
    private TableView<ReleaseNote> releaseTableView;

    @FXML
    private TableColumn<ReleaseNote,String> dateTableColumn;

    @FXML
    private TableColumn<ReleaseNote,String> timeTableColumn;

    @FXML
    private TableColumn<ReleaseNote,String> productTableColumn;

    @FXML
    private TableColumn<ReleaseNote,String> qtyTableColumn;

    @FXML
    private TableColumn<ReleaseNote,String> palletsTableColumn;

    @FXML
    private TableColumn<ReleaseNote,String> warehousemanTableColumn;

    @FXML
    private TableColumn<ReleaseNote,String> shipperTableColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button productDetailsButton;

    @FXML
    private Button warehousemanDetailsButton;

    @FXML
    private Button shipperDetailsButton;

    public void initialize() {
        fillTableView();
        searchTextField.setOnKeyTyped(this::searchReleasedHistory);
        productDetailsButton.setOnAction(this::getProductDetails);
        warehousemanDetailsButton.setOnAction(this::getWarehousemanDetails);
        shipperDetailsButton.setOnAction(this::getShipperDetails);
    }

    private void getWarehousemanDetails(ActionEvent event) {
        if (!releaseTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = releaseTableView.getSelectionModel().getSelectedIndex();
            String id = RELEASE_NOTE_LIST.get(tableIndexForAll).getWarehousemanId();
            String firstName = RELEASE_NOTE_LIST.get(tableIndexForAll).getWarehousemanFirstName();
            String lastName = RELEASE_NOTE_LIST.get(tableIndexForAll).getWarehousemanLastName();
            detailWarehouseman = new Warehouseman(id, firstName, lastName);
            detailValue = 2;
            showPane("/fxml/control/getInfoPane.fxml", "Warehouseman Details");
        }
    }
//
    private void getProductDetails(ActionEvent event) {
        if (!releaseTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = releaseTableView.getSelectionModel().getSelectedIndex();
            String id = RELEASE_NOTE_LIST.get(tableIndexForAll).getProductId();
            String description = RELEASE_NOTE_LIST.get(tableIndexForAll).getProductDescription();
            int productsQty = Integer.parseInt(RELEASE_NOTE_LIST.get(tableIndexForAll).getProductsQuantity());
            int palletsQty = Integer.parseInt(RELEASE_NOTE_LIST.get(tableIndexForAll).getPalletsQuantity());
            int productsPerOnePallet = productsQty / palletsQty;
            detailProduct = new Product(id, description, productsPerOnePallet);
            detailValue = 1;
            showPane("/fxml/control/getInfoPane.fxml", "Product Details");
        }
    }

    private void getShipperDetails(ActionEvent event) {
        if (!releaseTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = releaseTableView.getSelectionModel().getSelectedIndex();
            String id = RELEASE_NOTE_LIST.get(tableIndexForAll).getShipperId();
            String firstName = RELEASE_NOTE_LIST.get(tableIndexForAll).getShipperFirstName();
            String lastName = RELEASE_NOTE_LIST.get(tableIndexForAll).getShipperLastName();
            String company = RELEASE_NOTE_LIST.get(tableIndexForAll).getShipperCompany();
            String vehicle = RELEASE_NOTE_LIST.get(tableIndexForAll).getVehicleRegistrationNumber();
            detailShipper = new Shipper(id, firstName, lastName, company, vehicle);
            detailValue = 3;
            showPane("/fxml/control/getInfoPane.fxml", "Shipper Details");
        }
    }

    private void fillTableView() {
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        productTableColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        qtyTableColumn.setCellValueFactory(new PropertyValueFactory<>("productsQuantity"));
        palletsTableColumn.setCellValueFactory(new PropertyValueFactory<>("palletsQuantity"));
        warehousemanTableColumn.setCellValueFactory(new PropertyValueFactory<>("warehousemanId"));
        shipperTableColumn.setCellValueFactory(new PropertyValueFactory<>("shipperId"));
        releaseTableView.setItems(RELEASE_NOTE_LIST);
    }

    private void searchReleasedHistory(KeyEvent event) {
        releaseTableView.setItems(ReleaseNote.getSearchedList(RELEASE_NOTE_LIST, searchTextField.getText()));
    }
}
