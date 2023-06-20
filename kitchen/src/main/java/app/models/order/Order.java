package app.models.order;

import app.models.product.Product;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Order extends OrderDTO implements IOrder, Serializable {
    public UUID id;
    private List<Product> products;
    private float amount;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
