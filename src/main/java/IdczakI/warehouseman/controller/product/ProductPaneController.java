package IdczakI.warehouseman.controller.product;

import IdczakI.warehouseman.controller.MainController;
import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ProductPaneController extends MainController {

    static Product productForEdit = new Product("", "", 0);
    static int tableIndexForEdit;

    @FXML
    private TableView<Product> productsTableView;

    @FXML
    private TableColumn<Product, String> idTableColumn;

    @FXML
    private TableColumn<Product, String> descriptionTableColumn;

    @FXML
    private TableColumn<Product, Integer> qtyTableColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button newProductButton;

    @FXML
    private Button editProductButton;

    @FXML
    private Button deleteProductButton;

    public void initialize() {
        fillTableView();
        searchTextField.setOnKeyTyped(this::searchProduct);
        newProductButton.setOnAction(this::addProduct);
        editProductButton.setOnAction(this::editProduct);
    }

    private void editProduct(ActionEvent event) {
        productsTableView.setItems(getLIST());
        if (!productsTableView.getSelectionModel().isEmpty()) {
            tableIndexForEdit = productsTableView.getSelectionModel().getSelectedIndex();
            productForEdit = productsTableView.getItems().get(tableIndexForEdit);
            showPane("/fxml/product/editProductPane.fxml", "Edit Product");
        }
    }

    private void addProduct(ActionEvent event) {
        productsTableView.setItems(getLIST());
        showPane("/fxml/product/newProductPane.fxml", "Add Product");
    }

    private void searchProduct(KeyEvent event) {
        productsTableView.setItems(Product.getSearchedList(getLIST(), searchTextField.getText()));
    }

    private void fillTableView() {
        reader.readFiles();
        getLIST().addAll(IOFile.PRODUCT_MAP.values());
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        qtyTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantityPerOnePallet"));
        productsTableView.setItems(getLIST());
    }

}