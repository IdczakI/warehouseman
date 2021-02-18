package IdczakI.warehouseman.controller.product;

import IdczakI.warehouseman.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProductPaneController extends ProductPaneController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField qtyTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button editProductButton;

    public void initialize() {
        fillTextFields();
        editProductButton.setOnAction(this::editProduct);
    }

    private void editProduct(ActionEvent event) {
        getLIST().set(tableIndexForEdit, new Product(idTextField.getText(), descriptionTextField.getText(),
                Product.getIntFromTextField(qtyTextField)));
        Stage stage = (Stage) editProductButton.getScene().getWindow();
        stage.close();
    }

    private void fillTextFields() {
        idTextField.setText(productForEdit.getId());
        descriptionTextField.setText(productForEdit.getDescription());
        qtyTextField.setText(String.valueOf(productForEdit.getQuantityPerOnePallet()));
    }
}
