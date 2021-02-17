package IdczakI.warehouseman.model;

import IdczakI.warehouseman.io.IOFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class GoodsReleaseNote {

    private Inventory inventory;
    private LocalDate date;
    private LocalTime time;
    private Warehouseman warehouseman;
    private TruckDriver truckDriver;

    public GoodsReleaseNote(Inventory inventory, LocalDate date, LocalTime time,
                            Warehouseman warehouseman, TruckDriver truckDriver) {
        this.inventory = inventory;
        this.date = date;
        this.time = time;
        this.warehouseman = warehouseman;
        this.truckDriver = truckDriver;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Warehouseman getWarehouseman() {
        return warehouseman;
    }

    public TruckDriver getTruckDriver() {
        return truckDriver;
    }

    @Override
    public String toString() {
        return inventory.getPallet().getProduct().getId() + "," + date.format(IOFile.dateFormatter) + ","
                + time.format(IOFile.timeFormatter) + "," + warehouseman.getId() + "," + truckDriver.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsReleaseNote)) return false;
        GoodsReleaseNote that = (GoodsReleaseNote) o;
        return Objects.equals(inventory, that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory);
    }
}
