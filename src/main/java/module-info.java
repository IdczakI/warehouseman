module warehouseman {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports IdczakI.warehouseman.main to javafx.graphics;
    opens IdczakI.warehouseman.controller to javafx.fxml;
    opens IdczakI.warehouseman.controller.product to javafx.fxml;
    opens IdczakI.warehouseman.controller.shipper to javafx.fxml;
    opens IdczakI.warehouseman.model to javafx.base;
}