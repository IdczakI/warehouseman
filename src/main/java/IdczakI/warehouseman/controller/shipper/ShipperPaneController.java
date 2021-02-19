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
        getShippersList().addAll(IOFile.SHIPPER_MAP.values());
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        companyTableColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        vehicleNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleRegistrationNumber"));
        shippersTableView.setItems(getShippersList());
    }

    private void searchShipper(KeyEvent event) {
        shippersTableView.setItems(Shipper.getSearchedList(getShippersList(), searchTextField.getText()));
    }

    private void addShipper(ActionEvent event) {
        shippersTableView.setItems(getShippersList());
        showPane("/fxml/shipper/addShipperPane.fxml", "Add Shipper");
    }

    private void editShipper(ActionEvent event) {
        shippersTableView.setItems(getShippersList());
        if (!shippersTableView.getSelectionModel().isEmpty()) {
            setTableIndexForEdit(shippersTableView.getSelectionModel().getSelectedIndex());
            shipperForEdit = shippersTableView.getItems().get(getTableIndexForEdit());
            showPane("/fxml/shipper/editShipperPane.fxml", "Edit Shipper");
        }
    }

    private void deleteShipper(ActionEvent event) {
        if (!shippersTableView.getSelectionModel().isEmpty()) {
            setTableIndexForEdit(shippersTableView.getSelectionModel().getSelectedIndex());
            deleteValue = "S";
            showPane("/fxml/delete/deletePane.fxml", "Delete Shipper");
        }
    }
}
