package IdczakI.warehouseman.model;

import java.util.Objects;

public class Product {

    private String id;
    private double weight; //kg
    private int quantityOnOnePallet;

    public Product(String id, double weight, int quantityOnOnePallet) {
        this.id = id;
        this.weight = weight;
        this.quantityOnOnePallet = quantityOnOnePallet;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantityOnOnePallet() {
        return quantityOnOnePallet;
    }

    @Override
    public String toString() {
        return id + "," + weight + "," + quantityOnOnePallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
