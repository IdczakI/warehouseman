package IdczakI.warehouseman.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TableView<?> productsTableView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button newProductButton;

    @FXML
    private Button editProductButton;

    @FXML
    private Button deleteProductButton;

    public void initialize(){

    }
}
