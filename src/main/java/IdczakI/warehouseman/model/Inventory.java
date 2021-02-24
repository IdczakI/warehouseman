package IdczakI.warehouseman.model;

import java.util.Objects;

public class Inventory {
    private Product product;
    private int palletQty;

    public Inventory(Product product, int palletQty) {
        this.product = product;
        this.palletQty = palletQty;
    }

    public Product getProduct() {
        return product;
    }

    public int getPalletQty() {
        return palletQty;
    }

    @Override
    public String toString() {
        return product.getId() + Product.REGEX + palletQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(product, inventory.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}

