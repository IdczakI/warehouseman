package IdczakI.warehouseman.model;

import java.util.Objects;

public class Pallet {

    private Product product;
    private double netWeight;
    private static final double EUROPAL_WEIGHT = 25; //kg
    private double grossWeight;

    public Pallet(Product product) {
        this.product = product;
        this.netWeight = product.getWeight() * product.getQuantityOnOnePallet();
        this.grossWeight = EUROPAL_WEIGHT + this.netWeight;
    }

    public Product getProduct() {
        return product;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public double getPalletItselfWeight() {
        return EUROPAL_WEIGHT;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    @Override
    public String toString() {
        return product + "," + netWeight + "," + EUROPAL_WEIGHT + "," + grossWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pallet)) return false;
        Pallet pallet = (Pallet) o;
        return Objects.equals(product, pallet.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
