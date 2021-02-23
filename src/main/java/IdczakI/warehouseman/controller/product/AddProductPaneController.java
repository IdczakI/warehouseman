package IdczakI.warehouseman.controller.product;

import IdczakI.warehouseman.model.Model;
import IdczakI.warehouseman.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductPaneController extends ProductPaneController {

    Model model = new Model();

    @FXML
    private TextField idTextField;

    @FXML
    private TextField qtyTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button addProductButton;

    public void initialize() {
        addProductButton.setOnAction(this::productButton);
    }

    private void productButton(ActionEvent event) {
        Product product = new Product(idTextField.getText(), descriptionTextField.getText(),
                model.getIntFromTextField(qtyTextField));
        if (!PRODUCT_LIST.contains(product))
            PRODUCT_LIST.add(product);
        Stage stage = (Stage) addProductButton.getScene().getWindow();
        stage.close();
    }
}
