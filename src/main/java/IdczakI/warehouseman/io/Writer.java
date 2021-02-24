package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer extends IOFile {


    public void writeFiles() {
        try (BufferedWriter productWriter = new BufferedWriter(new FileWriter(productsFile));
             BufferedWriter inventoryWriter = new BufferedWriter(new FileWriter(inventoryFile));
//             BufferedWriter warehousemanWriter = new BufferedWriter(new FileWriter(warehousemanFile));
             BufferedWriter truckDriverWriter = new BufferedWriter(new FileWriter(shipperFile));
             BufferedWriter goodsReceivedWriter = new BufferedWriter(new FileWriter(goodsReceivedFile));
             BufferedWriter goodsReleaseWriter = new BufferedWriter(new FileWriter(goodsReleaseFile))
        ) {
            createFile();
            for (Product product : PRODUCT_MAP.values()) {
                productWriter.write(product.toCsv());
                productWriter.newLine();
            }
            for (Map.Entry<Product, Integer> inventory : INVENTORY_MAP.entrySet()) {
                inventoryWriter.write(inventory.getKey().getId() + Product.getREGEX() + inventory.getValue());
                inventoryWriter.newLine();
            }
//            for (Warehouseman warehouseman : WAREHOUSEMAN_MAP.values()) {
//                warehousemanWriter.write(warehouseman.toCsv());
//                warehousemanWriter.newLine();
//            }
            for (Shipper shipper : SHIPPER_MAP.values()) {
                truckDriverWriter.write(shipper.toCsv());
                truckDriverWriter.newLine();
            }
            for (ReceivedNote receivedNote : RECEIVED_LIST) {
                goodsReceivedWriter.write(receivedNote.toString());
                goodsReceivedWriter.newLine();
            }
            for (ReleaseNote releaseNote : RELEASE_LIST) {
                goodsReleaseWriter.write(releaseNote.toString());
                goodsReleaseWriter.newLine();
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFiles() {
    }
}
