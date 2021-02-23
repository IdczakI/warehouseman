package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader extends IOFile {

    private final static String REGEX = ",,";

    public void readFiles() {
        try (BufferedReader productReader = new BufferedReader(new FileReader(productsFile));
             BufferedReader inventoryReader = new BufferedReader(new FileReader(inventoryFile));
             BufferedReader warehousemanReader = new BufferedReader(new FileReader(warehousemanFile));
             BufferedReader truckDriverReader = new BufferedReader(new FileReader(shipperFile));
             BufferedReader goodsReceivedReader = new BufferedReader(new FileReader(goodsReceivedFile));
             BufferedReader goodsReleaseReader = new BufferedReader(new FileReader(goodsReleaseFile))
        ) {
            createFile();
            productReader.lines().forEach(this::fillProductMap);
            inventoryReader.lines().forEach(this::fillInventoryMap);
            warehousemanReader.lines().forEach(this::fillWarehousemanMap);
            truckDriverReader.lines().forEach(this::fillTruckDriverMap);
            goodsReceivedReader.lines().forEach(this::fillGoodsReceivedList);
            goodsReleaseReader.lines().forEach(this::fillGoodsReleaseList);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void fillProductMap(String s) {
        String[] c = s.split(REGEX);
        PRODUCT_MAP.put(c[0], new Product(c[0], c[1], Integer.parseInt(c[2])));

    }

    private void fillInventoryMap(String s) {
        String[] c = s.split(REGEX);
        if (PRODUCT_MAP.containsKey(c[0])) {
            INVENTORY_MAP.put(c[0], new Inventory(PRODUCT_MAP.get(c[0]), Integer.parseInt(c[1])));
        } else System.out.println("file error");
    }

    private void fillWarehousemanMap(String s) {
        String[] c = s.split(REGEX);
        WAREHOUSEMAN_MAP.put(c[0], new Warehouseman(c[0], c[1], c[2], c[3]));
    }

    private void fillTruckDriverMap(String s) {
        String[] c = s.split(REGEX);
        SHIPPER_MAP.put(c[0], new Shipper(c[0], c[1], c[2], c[3], c[4]));
    }

    private void fillGoodsReceivedList(String s) {
        String[] c = s.split(REGEX);
        RECEIVED_LIST.add(new ReceivedNote(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8]));
    }

    private void fillGoodsReleaseList(String s) {
        String[] c = s.split(REGEX);
        RELEASE_LIST.add(new ReleaseNote(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11],
                c[12], c[13]));
    }

    @Override
    public void writeFiles() {
    }
}
