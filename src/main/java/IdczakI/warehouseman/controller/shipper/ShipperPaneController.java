package IdczakI.warehouseman.controller.shipper;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Shipper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ShipperPaneController extends MainController {

    static Shipper shipperForEdit = new Shipper("", "", "", "", "");

    @FXML
    private TableView<Shipper> shippersTableView;

    @FXML
    private TableColumn<Shipper, String> idTableColumn;

    @FXML
    private TableColumn<Shipper, String> firstNameTableColumn;

    @FXML
    private TableColumn<Shipper, String> lastNameTableColumn;

    @FXML
    private TableColumn<Shipper, String> companyTableColumn;

    @FXML
    private TableColumn<Shipper, String> vehicleNumberTableColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button addShipperButton;

    @FXML
    private Button editShipperButton;

    @FXML
    private Button deleteShipperButton;

    public void initialize() {
        fillTableView();
        searchTextField.setOnKeyTyped(this::searchShipper);
        addShipperButton.setOnAction(this::addShipper);
        editShipperButton.setOnAction(this::editShipper);
        deleteShipperButton.setOnAction(this::deleteShipper);
    }

    private void fillTableView() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        companyTableColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        vehicleNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleRegistrationNumber"));
        shippersTableView.setItems(SHIPPER_LIST);
    }

    private void searchShipper(KeyEvent event) {
        shippersTableView.setItems(Shipper.getSearchedList(SHIPPER_LIST, searchTextField.getText()));
    }

    private void addShipper(ActionEvent event) {
        shippersTableView.setItems(SHIPPER_LIST);
        showPane("/fxml/shipper/addShipperPane.fxml", "Add Shipper");
    }

    private void editShipper(ActionEvent event) {
        shippersTableView.setItems(SHIPPER_LIST);
        if (!shippersTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = shippersTableView.getSelectionModel().getSelectedIndex();
            shipperForEdit = shippersTableView.getItems().get(tableIndexForAll);
            showPane("/fxml/shipper/editShipperPane.fxml", "Edit Shipper");
        }
    }

    private void deleteShipper(ActionEvent event) {
        if (!shippersTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = shippersTableView.getSelectionModel().getSelectedIndex();
            deleteValue= "S";
            showPane("/fxml/control/deletePane.fxml", "Delete Shipper");
        }
    }
}
