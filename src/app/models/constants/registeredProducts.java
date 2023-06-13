package app.models.constants;

import app.models.order.Product;

public class registeredProducts {
    public Product[] getRegisterdProducts() {
        Product[] registeredProducts = new Product[10];
        registeredProducts[registeredProducts.length] = new Product("Hamburger", 10);
        return registeredProducts;
    }
}
