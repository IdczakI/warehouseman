package IdczakI.warehouseman.model;

import IdczakI.warehouseman.io.IOFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class GoodsReceivedNote {

    private Product product;
    private int quantityOfPallets;
    private LocalDate date;
    private LocalTime time;
    private Warehouseman warehouseman;

    public GoodsReceivedNote(Product product, int quantityOfPallets, LocalDate date,
                             LocalTime time, Warehouseman warehouseman) {
        this.product = product;
        this.quantityOfPallets = quantityOfPallets;
        this.date = date;
        this.time = time;
        this.warehouseman = warehouseman;
    }

    public Product getProduct() {
        return product;
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

    public int getQuantityOfPallets() {
        return quantityOfPallets;
    }

    @Override
    public String toString() {
        return product.getId() + "," + quantityOfPallets + "," + date.format(IOFile.DATE_FORMATTER) +
                "," + time.format(IOFile.TIME_FORMATTER) + "," + warehouseman.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsReceivedNote)) return false;
        GoodsReceivedNote that = (GoodsReceivedNote) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
