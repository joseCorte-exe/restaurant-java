package app.models.product;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {
    private UUID id;
    private String name;
    private float price;
    private StringBuilder specifications;
    private int amount;

    public Product(String name, int price, StringBuilder specifications) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.specifications = specifications;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public StringBuilder getSpecifications() {
        return specifications;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
