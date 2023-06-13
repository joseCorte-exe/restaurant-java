package app.models.order;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Product> products;
    private float amount;

    public Order(List<Product> products) {
        this.id = UUID.randomUUID();
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public float getAmount() {
        return amount;
    }
}
