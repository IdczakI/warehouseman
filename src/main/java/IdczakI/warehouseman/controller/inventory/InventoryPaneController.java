package IdczakI.warehouseman.controller.inventory;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.InventoryNew;
import IdczakI.warehouseman.model.Model;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryPaneController extends MainController {

    Model model = new Model();
    private ObservableList<InventoryNew> inventoryNewObservableList = model.createInventoryNewList(IOFile.INVENTORY_MAP);

    @FXML
    private TableView<InventoryNew> inventoryTableView;

    @FXML
    private TableColumn<InventoryNew, String> productIdTableColumn;

    @FXML
    private TableColumn<InventoryNew, String> productDescriptionTableColumn;

    @FXML
    private TableColumn<InventoryNew, Integer> qtyTableColumn;

    @FXML
    private TableColumn<InventoryNew, Integer> palletsTableColumn;

    @FXML
    private TextField searchTextField;


    public void initialize() {
        fillTableView();
        searchTextField.setOnKeyTyped(event -> inventoryTableView
                    .setItems(InventoryNew.getSearchedList(inventoryNewObservableList, searchTextField.getText())));
    }

    private void fillTableView() {
        productIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        qtyTableColumn.setCellValueFactory(new PropertyValueFactory<>("ProductQty"));
        palletsTableColumn.setCellValueFactory(new PropertyValueFactory<>("PalletQty"));
        inventoryTableView.setItems(inventoryNewObservableList);
    }

}
