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
        LocalDate localDate = LocalDate.now();
        localDate.format(IOFile.DATE_FORMATTER);
        LocalTime localTime = LocalTime.now();
        localTime.format(IOFile.TIME_FORMATTER);
        IOFile.GOODS_RELEASE_SET.add(new GoodsReleaseNote(
                new Product("SUPER",12),
                12, localDate, localTime, IOFile.WAREHOUSEMAN_MAP.get("140A"),
                IOFile.TRUCK_DRIVER_MAP.get("111111")
        ));
        writer.writeFiles();





    }


}
