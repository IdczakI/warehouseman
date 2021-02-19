package IdczakI.warehouseman.main;

import IdczakI.warehouseman.io.Reader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.readFiles();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/mainPane.fxml"));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Warehouseman");
        primaryStage.show();

        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/fxml/control/warehousemanLoginPane.fxml"));
        Scene scene1 = new Scene(pane1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }
}
