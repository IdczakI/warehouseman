package IdczakI.warehouseman.main;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.io.Reader;
import IdczakI.warehouseman.io.Writer;
import IdczakI.warehouseman.model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {


        IOFile reader = new Reader();
        IOFile writer = new Writer();

        reader.readFiles();
        System.out.println(IOFile.GOODS_RECEIVED_SET);
        System.out.println(IOFile.GOODS_RELEASE_SET);
        Inventory inventory = IOFile.INVENTORY_MAP.get("ten");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Warehouseman warehouseman = IOFile.WAREHOUSEMAN_MAP.get("127C");
        TruckDriver truckDriver = IOFile.TRUCK_DRIVER_MAP.get("123123");
        IOFile.GOODS_RELEASE_SET.add(new GoodsReleaseNote(inventory, localDate, localTime, warehouseman, truckDriver));
        writer.writeFiles();




    }


}
