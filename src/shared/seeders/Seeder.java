package shared.seeders;

import app.models.client.Bill;
import app.models.client.Client;
import app.models.order.Product;

import java.util.ArrayList;
import java.util.List;

public class Seeder {
    Product[] products = new Product[4];
    List<Client> clients = new ArrayList<>();
    private void productsSeeder() {
        products[0] = new Product("Nhoque", 10);
        products[1] = new Product("Spaghetti", 20);
        products[2] = new Product("Carbonara", 30);
        products[3] = new Product("Raviolli", 40);
    }
    private void clientsSeeder() {
        clients.add(new Client("Client 1", new Bill(), 1));
        clients.add(new Client("Client 2", new Bill(), 2));
        clients.add(new Client("Client 3", new Bill(), 3));
    }
    public Seeder() {
        productsSeeder();
        clientsSeeder();
    }

    public Product[] getProducts() {
        return products;
    }
    public List<Client> getClients() {
        return clients;
    }
}
