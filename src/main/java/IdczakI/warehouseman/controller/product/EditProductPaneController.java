package IdczakI.warehouseman.controller.product;

import IdczakI.warehouseman.model.Model;
import IdczakI.warehouseman.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProductPaneController extends ProductPaneController {

    Model model = new Model();

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
        Product product = new Product(productForEdit.getId(), descriptionTextField.getText(),
                model.getIntFromTextField(qtyTextField));
        PRODUCT_LIST.set(tableIndexForAll, product);
//        if (!getProductsList().contains(product))
        Stage stage = (Stage) editProductButton.getScene().getWindow();
        stage.close();
    }

    private void fillTextFields() {
        idTextField.setText(productForEdit.getId());
        descriptionTextField.setText(productForEdit.getDescription());
        qtyTextField.setText(String.valueOf(productForEdit.getQuantityPerOnePallet()));
    }
}
