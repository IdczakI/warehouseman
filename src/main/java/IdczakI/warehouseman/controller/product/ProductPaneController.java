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
        deleteProductButton.setOnAction(this::deleteProduct);
    }

    private void fillTableView() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        qtyTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantityPerOnePallet"));
        productsTableView.setItems(PRODUCT_LIST);
    }

    private void searchProduct(KeyEvent event) {
        productsTableView.setItems(Product.getSearchedList(PRODUCT_LIST, searchTextField.getText()));
    }

    private void addProduct(ActionEvent event) {
        productsTableView.setItems(PRODUCT_LIST);
        showPane("/fxml/product/addProductPane.fxml", "Add Product");
    }

    private void editProduct(ActionEvent event) {
        productsTableView.setItems(PRODUCT_LIST);
        if (!productsTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = productsTableView.getSelectionModel().getSelectedIndex();
            productForEdit = productsTableView.getItems().get(tableIndexForAll);
            showPane("/fxml/product/editProductPane.fxml", "Edit Product");
        }
    }

    private void deleteProduct(ActionEvent event) {
        if (!productsTableView.getSelectionModel().isEmpty()) {
            tableIndexForAll = productsTableView.getSelectionModel().getSelectedIndex();
            deleteValue = "P";
            showPane("/fxml/control/deletePane.fxml", "Delete Product");
        }
    }

}
