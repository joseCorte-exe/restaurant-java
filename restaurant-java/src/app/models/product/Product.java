package app.models.product;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable {
    private UUID id;
    private String name;
    private float price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
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
}
