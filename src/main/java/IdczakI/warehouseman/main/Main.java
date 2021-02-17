package IdczakI.warehouseman.main;

import IdczakI.warehouseman.io.IOFile;
import IdczakI.warehouseman.io.Reader;
import IdczakI.warehouseman.io.Writer;
import IdczakI.warehouseman.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {


        IOFile reader = new Reader();
        IOFile writer = new Writer();

//        reader.readFiles();
//        System.out.println(IOFile.WAREHOUSEMAN_MAP);
//        System.out.println(IOFile.TRUCK_DRIVER_MAP);
//        IOFile.WAREHOUSEMAN_MAP.put("123C", new Warehouseman("140A", "Tadeusz", "Nowak"));
//        IOFile.TRUCK_DRIVER_MAP.put("125850", new TruckDriver("125850", "Damian", "Rewers"
//                , "Rewers Company", "PN 66589"));
//        writer.writeFiles();
        LocalDateTime local = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH-mm-ss");



        System.out.println(local.format(dateTimeFormatter));
        System.out.println(local.getDayOfWeek());
    }


}
