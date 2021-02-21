package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer extends IOFile {


    public void writeFiles() {
        try (BufferedWriter productWriter = new BufferedWriter(new FileWriter(productsFile,true));
             BufferedWriter stockWriter = new BufferedWriter(new FileWriter(inventoryFile,true));
             BufferedWriter warehousemanWriter = new BufferedWriter(new FileWriter(warehousemanFile,true));
             BufferedWriter truckDriverWriter = new BufferedWriter(new FileWriter(shipperFile,true));
             BufferedWriter goodsReceivedWriter = new BufferedWriter(new FileWriter(goodsReceivedFile));
             BufferedWriter goodsReleaseWriter = new BufferedWriter(new FileWriter(goodsReleaseFile))
        ) {
            createFile();
//            for (Product product : PRODUCT_MAP.values()) {
//                if (product.toString().contains(",,"))
//                    productWriter.write(product.toCsv());
//                productWriter.newLine();
//            }
//            for (Inventory inventory : INVENTORY_MAP.values()) {
//                stockWriter.write(inventory.toString());
//                stockWriter.newLine();
//            }
//            for (Warehouseman warehouseman : WAREHOUSEMAN_MAP.values()) {
//                warehousemanWriter.write(warehouseman.toCsv());
//                warehousemanWriter.newLine();
//            }
//            for (Shipper shipper : SHIPPER_MAP.values()) {
//                truckDriverWriter.write(shipper.toString());
//                truckDriverWriter.newLine();
//            }
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
