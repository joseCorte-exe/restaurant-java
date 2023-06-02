package DB;

import app.classes.order.Product;
import app.seeders.Seeder;

public class DB {
    private Seeder seeder = new Seeder();

    public Product[] getProducts() {
        Product[] products = seeder.getProducts();
        return  products;
    }
}
