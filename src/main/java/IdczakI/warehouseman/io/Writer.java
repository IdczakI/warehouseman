package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.Product;
import IdczakI.warehouseman.model.Inventory;
import IdczakI.warehouseman.model.TruckDriver;
import IdczakI.warehouseman.model.Warehouseman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer extends IOFile {


    @Override
    public void writeFiles() {
        try (BufferedWriter productWriter = new BufferedWriter(new FileWriter(productsFile));
             BufferedWriter stockWriter = new BufferedWriter(new FileWriter(stockFile));
             BufferedWriter warehousemanWriter = new BufferedWriter(new FileWriter(warehousemanFile));
             BufferedWriter truckDriverWriter = new BufferedWriter(new FileWriter(truckDriverFile))
        ) {
            createFile();
            for (Product product : PRODUCT_MAP.values()) {
                productWriter.write(product.toString());
                productWriter.newLine();
            }
            for (Inventory inventory : INVENTORY_SET) {
                stockWriter.write(inventory.toString());
                stockWriter.newLine();
            }
            for (Warehouseman warehouseman : WAREHOUSEMAN_MAP.values()) {
                warehousemanWriter.write(warehouseman.toString());
                warehousemanWriter.newLine();
            }
            for (TruckDriver truckDriver : TRUCK_DRIVER_MAP.values()) {
                truckDriverWriter.write(truckDriver.toString());
                truckDriverWriter.newLine();
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFiles() {}
}
