package IdczakI.warehouseman.controller.product;

import IdczakI.warehouseman.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewProductPaneController extends ProductPaneController {

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
                Product.getIntFromTextField(qtyTextField));
        if (!getLIST().contains(product))
            getLIST().add(product);
        Stage stage = (Stage) addProductButton.getScene().getWindow();
        stage.close();
    }
}
