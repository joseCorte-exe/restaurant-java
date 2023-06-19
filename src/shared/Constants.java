package shared;

import app.models.client.Bill;
import app.models.client.Client;
import app.models.order.Product;
import shared.seeders.Seeder;

import java.util.List;

public class Constants {
    private Seeder seeder = new Seeder();
    private List<Client> clients = seeder.getClients();

    public Product[] getProducts() {
        Product[] products = seeder.getProducts();
        return  products;
    }
    public List<Client> getClients() {
        return this.clients;
    }

    public Client addClient() {
        Client client = new Client("Client " + clients.size() + 1, new Bill(),  clients.size() + 1);
        clients.add(client);
        return client;
    }

    public Client findClient(List<Client> clients, String key) throws Exception {
        for (Client client : clients) {
            if (client.getTable() == Integer.parseInt(key)) return client;
            if (client.getName() == key) return client;
        }
        throw new Exception("not found -> no clients founds");
    }
}