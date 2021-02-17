package IdczakI.warehouseman.model;

import java.util.Objects;

public class Inventory {
    private Pallet pallet;
    private int quantityOfPallets;

    public Inventory(Pallet pallet, int quantityOfPallets) {
        this.pallet = pallet;
        this.quantityOfPallets = quantityOfPallets;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public int getQuantityOfPallets() {
        return quantityOfPallets;
    }

    @Override
    public String toString() {
        return pallet.getProduct().getId() + "," + quantityOfPallets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(pallet, inventory.pallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pallet);
    }
}

