package IdczakI.warehouseman.controller.inventory;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.InventoryDetail;
import IdczakI.warehouseman.model.Model;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.stream.Stream;

public class InventoryPaneController extends MainController {

    Model model = new Model();

    @FXML
    private TableView<InventoryDetail> inventoryTableView;

    @FXML
    private TableColumn<InventoryDetail, String> productIdTableColumn;

    @FXML
    private TableColumn<InventoryDetail, String> productDescriptionTableColumn;

    @FXML
    private TableColumn<InventoryDetail, Integer> qtyTableColumn;

    @FXML
    private TableColumn<InventoryDetail, Integer> palletsTableColumn;

    @FXML
    private TextField searchTextField;


    public void initialize() {
        fillInventoryDetailsList();
        fillTableView();
        searchTextField.setOnKeyTyped(event -> inventoryTableView
                    .setItems(InventoryDetail.getSearchedList(INVENTORY_DETAIL_LIST, searchTextField.getText())));
    }


    private void fillTableView() {
        productIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        qtyTableColumn.setCellValueFactory(new PropertyValueFactory<>("ProductQty"));
        palletsTableColumn.setCellValueFactory(new PropertyValueFactory<>("PalletQty"));
        inventoryTableView.setItems(INVENTORY_DETAIL_LIST);
    }

}
