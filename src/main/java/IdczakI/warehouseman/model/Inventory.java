package IdczakI.warehouseman.model;

import java.util.Objects;

public class Inventory {
    private Product product;
    private int quantityOfPallets;

    public Inventory(Product product, int quantityOfPallets) {
        this.product = product;
        this.quantityOfPallets = quantityOfPallets;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantityOfPallets() {
        return quantityOfPallets;
    }

    @Override
    public String toString() {
        return product.getId() + Product.REGEX + quantityOfPallets;
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

