package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

abstract public class IOFile {

    final static String PRODUCTS_FILE_NAME = "src/main/resources/csv/product.csv";
    final static String STOCK_FILE_NAME = "src/main/resources/csv/inventory.csv";
    final static String WAREHOUSEMAN_FILE_NAME = "src/main/resources/csv/warehouseman.csv";
    final static String TRUCK_DRIVER_FILE_NAME = "src/main/resources/csv/driver.csv";
    final static String GOODS_RECEIVED_FILE_NAME = "src/main/resources/csv/received.csv";
    final static String GOODS_RELEASE_FILE_NAME = "src/main/resources/csv/release.csv";

    final static File productsFile = new File(PRODUCTS_FILE_NAME);
    final static File stockFile = new File(STOCK_FILE_NAME);
    final static File warehousemanFile = new File(WAREHOUSEMAN_FILE_NAME);
    final static File truckDriverFile = new File(TRUCK_DRIVER_FILE_NAME);
    final static File goodsReceivedFile = new File(GOODS_RECEIVED_FILE_NAME);
    final static File goodsReleaseFile = new File(GOODS_RELEASE_FILE_NAME);

    public static final Map<String, Product> PRODUCT_MAP = new HashMap<>();
    public static final Map<String, Warehouseman> WAREHOUSEMAN_MAP = new HashMap<>();
    public static final Map<String, TruckDriver> TRUCK_DRIVER_MAP = new HashMap<>();

    public static final Set<Inventory> INVENTORY_SET = new HashSet<>();
    public static final Set<GoodsReceivedNote> GOODS_RECEIVED_SET = new HashSet<>();
    public static final Set<GoodsReleaseNote> GOODS_RELEASE_SET = new HashSet<>();

    abstract public void readFiles();
    abstract public void writeFiles();

    void createFile() throws IOException {
        if (!productsFile.exists()) {
            boolean b = productsFile.createNewFile();
        }
        if (!stockFile.exists()) {
            boolean b = stockFile.createNewFile();
        }
        if (!warehousemanFile.exists()) {
            boolean b = warehousemanFile.createNewFile();
        }
        if (!truckDriverFile.exists()) {
            boolean b = truckDriverFile.createNewFile();
        }
        if (!goodsReceivedFile.exists()){
            boolean b = goodsReceivedFile.createNewFile();
        }
        if (!goodsReleaseFile.exists()){
            boolean b = goodsReleaseFile.createNewFile();
        }
    }
}
