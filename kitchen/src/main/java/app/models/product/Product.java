package app.models.product;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {
    private UUID id;
    private String name;
    private float price;
    private StringBuilder specifications;

    public Product(String name, int price, StringBuilder specifications) {
        this.name = name;
        this.price = price;
        this.specifications = specifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public StringBuilder getSpecifications() {
        return specifications;
    }
}
