package app.models.order;

import app.models.product.Product;

import java.util.List;
import java.util.UUID;

public interface IOrder {
    public String getStatus();

    public void setStatus(String status);

    public UUID getId();

    public List<Product> getProducts();

    public float getAmount();
}
