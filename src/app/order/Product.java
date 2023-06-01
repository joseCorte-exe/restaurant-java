package app.order;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
