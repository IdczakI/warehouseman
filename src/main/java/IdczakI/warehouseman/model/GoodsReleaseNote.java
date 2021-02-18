package IdczakI.warehouseman.model;

import IdczakI.warehouseman.io.IOFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class GoodsReleaseNote {

    private Product product;
    private int quantityOfPallets;
    private LocalDate date;
    private LocalTime time;
    private Warehouseman warehouseman;
    private TruckDriver truckDriver;

    public GoodsReleaseNote(Product product, int quantityOfPallets, LocalDate date, LocalTime time,
                            Warehouseman warehouseman, TruckDriver truckDriver) {
        this.product = product;
        this.quantityOfPallets = quantityOfPallets;
        this.date = date;
        this.time = time;
        this.warehouseman = warehouseman;
        this.truckDriver = truckDriver;
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

    public TruckDriver getTruckDriver() {
        return truckDriver;
    }

    public int getQuantityOfPallets() {
        return quantityOfPallets;
    }

    @Override
    public String toString() {
        return product.getId() + Product.REGEX + quantityOfPallets +  Product.REGEX + date.format(IOFile.DATE_FORMATTER)
                + Product.REGEX + time.format(IOFile.TIME_FORMATTER) + Product.REGEX + warehouseman.getId()
                + Product.REGEX + truckDriver.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsReleaseNote)) return false;
        GoodsReleaseNote that = (GoodsReleaseNote) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
