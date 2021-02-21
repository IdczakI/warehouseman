package IdczakI.warehouseman.io;

import IdczakI.warehouseman.model.*;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;

abstract public class IOFile {

    final static String PRODUCTS_FILE_NAME = "src/main/resources/csv/product.csv";
    final static String INVENTORY_FILE_NAME = "src/main/resources/csv/inventory.csv";
    final static String WAREHOUSEMAN_FILE_NAME = "src/main/resources/csv/warehouseman.csv";
    final static String SHIPPER_FILE_NAME = "src/main/resources/csv/shipper.csv";
    final static String GOODS_RECEIVED_FILE_NAME = "src/main/resources/csv/received.csv";
    final static String GOODS_RELEASE_FILE_NAME = "src/main/resources/csv/release.csv";

    final static File productsFile = new File(PRODUCTS_FILE_NAME);
    final static File inventoryFile = new File(INVENTORY_FILE_NAME);
    final static File warehousemanFile = new File(WAREHOUSEMAN_FILE_NAME);
    final static File shipperFile = new File(SHIPPER_FILE_NAME);
    final static File goodsReceivedFile = new File(GOODS_RECEIVED_FILE_NAME);
    final static File goodsReleaseFile = new File(GOODS_RELEASE_FILE_NAME);

    public static final Map<String, Product> PRODUCT_MAP = new HashMap<>();
    public static final Map<String, Warehouseman> WAREHOUSEMAN_MAP = new HashMap<>();
    public static final Map<String, Shipper> SHIPPER_MAP = new HashMap<>();
    public static final Map<String, Inventory> INVENTORY_MAP = new HashMap<>();

    public static final List<ReceivedNote> RECEIVED_LIST = new ArrayList<>();
    public static final List<ReleaseNote> RELEASE_LIST = new ArrayList<>();

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    abstract public void readFiles();

    abstract public void writeFiles();

    void createFile() throws IOException {
        if (!productsFile.exists()) {
            boolean b = productsFile.createNewFile();
        }
        if (!inventoryFile.exists()) {
            boolean b = inventoryFile.createNewFile();
        }
        if (!warehousemanFile.exists()) {
            boolean b = warehousemanFile.createNewFile();
        }
        if (!shipperFile.exists()) {
            boolean b = shipperFile.createNewFile();
        }
        if (!goodsReceivedFile.exists()) {
            boolean b = goodsReceivedFile.createNewFile();
        }
        if (!goodsReleaseFile.exists()) {
            boolean b = goodsReleaseFile.createNewFile();
        }
    }
}
