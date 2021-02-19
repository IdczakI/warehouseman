package IdczakI.warehouseman.controller;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.io.Reader;
import IdczakI.warehouseman.io.Writer;
import IdczakI.warehouseman.model.Product;
import IdczakI.warehouseman.model.Shipper;
import IdczakI.warehouseman.model.Warehouseman;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    static public final ObservableList<Product> PRODUCTS_LIST = FXCollections.observableArrayList();
    static public final ObservableList<Shipper> SHIPPERS_LIST = FXCollections.observableArrayList();
    static public final ObservableList<Warehouseman> WAREHOUSEMAN_LIST = FXCollections.observableArrayList();
    public static int tableIndexForEdit;
    public static String deleteValue = "";

    public IOFile writer = new Writer();

    public void showPane(String resource, String title) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(resource));
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
    }
}
