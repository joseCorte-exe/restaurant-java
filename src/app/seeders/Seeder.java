package app.seeders;

import app.classes.order.Product;

public class Seeder {
    Product[] products = new Product[4];
    private void productsSeeder() {

        products[0] = new Product("Nhoque", 10);
        products[1] = new Product("Spaghetti", 20);
        products[2] = new Product("Carbonara", 30);
        products[3] = new Product("Raviolli", 40);
    }
    public Seeder() {
        productsSeeder();
    }

    public Product[] getProducts() {
        return products;
    }
}
