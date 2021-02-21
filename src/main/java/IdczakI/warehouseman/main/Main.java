package IdczakI.warehouseman.main;

import IdczakI.warehouseman.io.Reader;
import IdczakI.warehouseman.io.Writer;
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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/control/userLoginPane.fxml"));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Warehouseman Login");
        primaryStage.show();

    }
    @Override
    public void stop(){
        Writer writer = new Writer();
        writer.writeFiles();
    }
}
