package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        PRODUCT_MAP.put(c[0], new Product(c[0], Double.parseDouble(c[1]), Integer.parseInt(c[2])));

    }

    private void fillInventoryMap(String s) {
        String[] c = s.split(",");
        if (PRODUCT_MAP.containsKey(c[0])) {
            INVENTORY_MAP.put(c[0], new Inventory(new Pallet(PRODUCT_MAP.get(c[0])), Integer.parseInt(c[1])));
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
        if (WAREHOUSEMAN_MAP.containsKey(c[3]) && INVENTORY_MAP.containsKey(c[0])) {
            Inventory inventory = INVENTORY_MAP.get(c[0]);
            Warehouseman warehouseman = WAREHOUSEMAN_MAP.get(c[3]);
            LocalDate localDate = LocalDate.parse(c[1], dateFormatter);
            LocalTime localTime = LocalTime.parse(c[2], timeFormatter);
            GOODS_RECEIVED_SET.add(new GoodsReceivedNote(inventory, localDate, localTime, warehouseman));
        }else System.out.println("file error");
    }

    private void fillGoodsReleaseSet(String s) {
        String[] c = s.split(",");
        if (INVENTORY_MAP.containsKey(c[0]) && WAREHOUSEMAN_MAP.containsKey(c[3]) && TRUCK_DRIVER_MAP.containsKey(c[4])){
            Inventory inventory = INVENTORY_MAP.get(c[0]);
            Warehouseman warehouseman = WAREHOUSEMAN_MAP.get(c[3]);
            LocalDate localDate = LocalDate.parse(c[1], dateFormatter);
            LocalTime localTime = LocalTime.parse(c[2], timeFormatter);
            TruckDriver truckDriver = TRUCK_DRIVER_MAP.get(c[4]);
            GOODS_RELEASE_SET.add(new GoodsReleaseNote(inventory, localDate, localTime, warehouseman, truckDriver));
        }else System.out.println("file error");
    }

    @Override
    public void writeFiles() {
    }
}
