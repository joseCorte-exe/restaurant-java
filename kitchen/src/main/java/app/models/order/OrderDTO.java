package app.models.order;

import app.models.product.Product;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
    private UUID id;
    private List<Product> products;
    private float amount;
    private String status;
}
