package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reader extends IOFile {

    @Override
    public void readFiles() {
        try (BufferedReader productReader = new BufferedReader(new FileReader(productsFile));
             BufferedReader inventoryReader = new BufferedReader(new FileReader(inventoryFile));
             BufferedReader warehousemanReader = new BufferedReader(new FileReader(warehousemanFile));
             BufferedReader truckDriverReader = new BufferedReader(new FileReader(truckDriverFile));
             BufferedReader goodsReceivedReader = new BufferedReader(new FileReader(goodsReceivedFile));
             BufferedReader goodsReleaseReader = new BufferedReader(new FileReader(goodsReleaseFile))
        ) {
            createFile();
            productReader.lines().forEach(this::fillProductMap);
            inventoryReader.lines().forEach(this::fillInventoryMap);
            warehousemanReader.lines().forEach(this::fillWarehousemanMap);
            truckDriverReader.lines().forEach(this::fillTruckDriverMap);
            goodsReceivedReader.lines().forEach(this::fillGoodsReceivedSet);
            goodsReleaseReader.lines().forEach(this::fillGoodsReleaseSet);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void fillProductMap(String s) {
        String[] c = s.split(",");
        PRODUCT_MAP.put(c[0], new Product(c[0], Integer.parseInt(c[1])));

    }

    private void fillInventoryMap(String s) {
        String[] c = s.split(",");
        if (PRODUCT_MAP.containsKey(c[0])) {
            INVENTORY_MAP.put(c[0], new Inventory(PRODUCT_MAP.get(c[0]),Integer.parseInt(c[1])));
        } else System.out.println("file error");
    }

    private void fillWarehousemanMap(String s) {
        String[] c = s.split(",");
        WAREHOUSEMAN_MAP.put(c[0], new Warehouseman(c[0], c[1], c[2]));
    }

    private void fillTruckDriverMap(String s) {
        String[] c = s.split(",");
        TRUCK_DRIVER_MAP.put(c[0], new TruckDriver(c[0], c[1], c[2], c[3], c[4]));
    }

    private void fillGoodsReceivedSet(String s) {
        String[] c = s.split(",");
        if (WAREHOUSEMAN_MAP.containsKey(c[4]) && PRODUCT_MAP.containsKey(c[0])) {
            Product product = PRODUCT_MAP.get(c[0]);
            Warehouseman warehouseman = WAREHOUSEMAN_MAP.get(c[4]);
            LocalDate localDate = LocalDate.parse(c[2], DATE_FORMATTER);
            LocalTime localTime = LocalTime.parse(c[3], TIME_FORMATTER);
            GOODS_RECEIVED_SET.add(new GoodsReceivedNote(product, Integer.parseInt(c[1]),
                    localDate, localTime, warehouseman));
        }else System.out.println("file error");
    }

    private void fillGoodsReleaseSet(String s) {
        String[] c = s.split(",");
        if (PRODUCT_MAP.containsKey(c[0]) && WAREHOUSEMAN_MAP.containsKey(c[4]) && TRUCK_DRIVER_MAP.containsKey(c[5])){
            Product product = PRODUCT_MAP.get(c[0]);
            Warehouseman warehouseman = WAREHOUSEMAN_MAP.get(c[4]);
            LocalDate localDate = LocalDate.parse(c[2], DATE_FORMATTER);
            LocalTime localTime = LocalTime.parse(c[3], TIME_FORMATTER);
            TruckDriver truckDriver = TRUCK_DRIVER_MAP.get(c[5]);
            GOODS_RELEASE_SET.add(new GoodsReleaseNote(product, Integer.parseInt(c[1]), localDate,
                    localTime, warehouseman, truckDriver));
        }else System.out.println("file error");
    }

    @Override
    public void writeFiles() {
    }
}
