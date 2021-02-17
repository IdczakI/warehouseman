package IdczakI.warehouseman.model;

public class GoodsReleaseNote {

    private Inventory inventory;
    private String date;
    private String hour;
    private Warehouseman warehouseman;
    private TruckDriver truckDriver;

    public GoodsReleaseNote(Inventory inventory, String date, String hour,
                            Warehouseman warehouseman, TruckDriver truckDriver) {
        this.inventory = inventory;
        this.date = date;
        this.hour = hour;
        this.warehouseman = warehouseman;
        this.truckDriver = truckDriver;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public Warehouseman getWarehouseman() {
        return warehouseman;
    }

    public TruckDriver getTruckDriver() {
        return truckDriver;
    }
}
