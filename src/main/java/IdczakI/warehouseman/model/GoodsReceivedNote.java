package IdczakI.warehouseman.model;

public class GoodsReceivedNote {

    private Inventory inventory;
    private String date;
    private String hour;
    private Warehouseman warehouseman;

    public GoodsReceivedNote(Inventory inventory, String date, String hour, Warehouseman warehouseman) {
        this.inventory = inventory;
        this.date = date;
        this.hour = hour;
        this.warehouseman = warehouseman;
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
}
