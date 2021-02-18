package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer extends IOFile {


    @Override
    public void writeFiles() {
        try (BufferedWriter productWriter = new BufferedWriter(new FileWriter(productsFile));
             BufferedWriter stockWriter = new BufferedWriter(new FileWriter(inventoryFile));
             BufferedWriter warehousemanWriter = new BufferedWriter(new FileWriter(warehousemanFile));
             BufferedWriter truckDriverWriter = new BufferedWriter(new FileWriter(truckDriverFile));
             BufferedWriter goodsReceivedWriter = new BufferedWriter(new FileWriter(goodsReceivedFile));
             BufferedWriter goodsReleaseWriter = new BufferedWriter(new FileWriter(goodsReleaseFile))
        ) {
            createFile();
            for (Product product : PRODUCT_MAP.values()) {
                if (product.toString().contains(",,"))
                productWriter.write(product.toString());
                productWriter.newLine();
            }
            for (Inventory inventory : INVENTORY_MAP.values()) {
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
            for (GoodsReceivedNote goodsReceivedNote : GOODS_RECEIVED_SET) {
                goodsReceivedWriter.write(goodsReceivedNote.toString());
                goodsReceivedWriter.newLine();
            }
            for (GoodsReleaseNote goodsReleaseNote : GOODS_RELEASE_SET) {
                goodsReleaseWriter.write(goodsReleaseNote.toString());
                goodsReleaseWriter.newLine();
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFiles() {}
}
