package shared;

import app.models.order.Product;
import app.seeders.Seeder;

public class Constants {
    private Seeder seeder = new Seeder();

    public Product[] getProducts() {
        Product[] products = seeder.getProducts();
        return  products;
    }
}
