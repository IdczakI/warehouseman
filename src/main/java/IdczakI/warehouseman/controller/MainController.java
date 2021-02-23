package IdczakI.warehouseman.controller;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.io.Writer;
import IdczakI.warehouseman.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public static final ObservableList<Product> PRODUCT_LIST = FXCollections.observableArrayList();
    public static final ObservableList<Shipper> SHIPPER_LIST = FXCollections.observableArrayList();
    public static final ObservableList<Warehouseman> WAREHOUSEMAN_LIST = FXCollections.observableArrayList();
    public static final ObservableList<ReceivedNote> RECEIVED_NOTE_LIST = FXCollections.observableArrayList();
    public static final ObservableList<ReleaseNote> RELEASE_NOTE_LIST = FXCollections.observableArrayList();
    public static int tableIndexForAll;
    public static String deleteValue = "";
    public static Warehouseman loginWarehouseman;
    public static Product detailProduct = new Product("","",0);
    public static Warehouseman detailWarehouseman = new Warehouseman("","","");
    public static Shipper detailShipper = new Shipper("","","","","");
    public static int detailValue;

    public IOFile writer = new Writer();

    public void showPane(String resource, String title) {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource(resource));
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
