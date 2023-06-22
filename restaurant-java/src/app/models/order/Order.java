package app.models.order;

import app.models.product.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order extends OrderDTO implements IOrder, Serializable {
    public UUID id;
    private List<Product> products;
    private float amount;
    public String status = "to prepare";
    public String preferences = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(List<Product> products, String preferences) {
        this.id = UUID.randomUUID();
        this.products = products;
        if (!preferences.isEmpty())
            this.preferences = preferences;
    }

    public String getPreferences() {
        return preferences;
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
        amount = products
                .stream()
                .reduce(
                    0,
                    (total, product) -> (int) (total + (
                        (product.getAmount() > 1)
                            ? product.getPrice() * product.getAmount()
                            : product.getPrice()
                    )),
                    Integer::sum
                );
        return amount;
    }
}
