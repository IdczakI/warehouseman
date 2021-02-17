package IdczakI.warehouseman.model;

import IdczakI.warehouseman.io.IOFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class GoodsReceivedNote {

    private Inventory inventory;
    private LocalDate date;
    private LocalTime time;
    private Warehouseman warehouseman;

    public GoodsReceivedNote(Inventory inventory, LocalDate date, LocalTime time, Warehouseman warehouseman) {
        this.inventory = inventory;
        this.date = date;
        this.time = time;
        this.warehouseman = warehouseman;
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

    @Override
    public String toString() {
        return inventory.getPallet().getProduct().getId() + "," + date.format(IOFile.dateFormatter)
                + "," + time.format(IOFile.timeFormatter) + "," + warehouseman.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsReceivedNote)) return false;
        GoodsReceivedNote that = (GoodsReceivedNote) o;
        return Objects.equals(inventory, that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory);
    }
}
