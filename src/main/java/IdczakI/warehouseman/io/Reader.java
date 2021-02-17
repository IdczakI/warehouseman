package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader extends IOFile {

    @Override
    public void readFiles() {
        try (BufferedReader productReader = new BufferedReader(new FileReader(productsFile));
             BufferedReader stockReader = new BufferedReader(new FileReader(stockFile));
             BufferedReader warehousemanReader = new BufferedReader(new FileReader(warehousemanFile));
             BufferedReader truckDriverReader = new BufferedReader(new FileReader(truckDriverFile))) {
            createFile();
            productReader.lines().forEach(this::fillProductMap);
            stockReader.lines().forEach(this::fillStockMap);
            warehousemanReader.lines().forEach(this::fillWarehousemanMap);
            truckDriverReader.lines().forEach(this::fillTruckDriverMap);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void fillProductMap(String s) {
        String[] c = s.split(",");
        PRODUCT_MAP.put(c[0], new Product(c[0], Double.parseDouble(c[1]), Integer.parseInt(c[2])));

    }

    private void fillStockMap(String s) {
        String[] c = s.split(",");
        if (PRODUCT_MAP.containsKey(c[0])) {
            INVENTORY_SET.add(new Inventory(new Pallet(PRODUCT_MAP.get(c[0])), Integer.parseInt(c[1])));
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

    @Override
    public void writeFiles() {
    }
}
