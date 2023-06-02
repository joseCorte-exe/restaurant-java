package app.classes.order;

import java.util.UUID;

public class Order {
    private UUID id;
    private Product[] products;
    private float amount;

    public Order(Product[] products) {
        this.id = UUID.randomUUID();
        this.products = products;
    }
}
