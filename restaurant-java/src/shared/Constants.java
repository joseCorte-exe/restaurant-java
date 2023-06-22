package shared;

import app.models.client.Bill;
import app.models.client.Client;
import app.models.product.Product;
import org.jetbrains.annotations.NotNull;
import shared.seeders.Seeder;

import java.util.List;

public class Constants {
    static private Seeder seeder = new Seeder();
    static private List<Client> clients = seeder.getClients();

    static public List<Product> getProducts() {
        List<Product> products = seeder.getProducts();
        return products;
    }
    public List<Client> getClients() {
        return this.clients;
    }

    static public @NotNull Client addClient() {
        Client client = new Client("Client " + clients.size() + 1, new Bill(),  clients.size() + 1);
        clients.add(client);
        return client;
    }

    @org.jetbrains.annotations.NotNull
    static public Client findClient(@NotNull List<Client> clients, String key) throws Exception {
        for (Client client : clients) {
            if (client.getTable() == Integer.parseInt(key)) return client;
            if (client.getName() == key) return client;
        }
        throw new Exception("not found -> no clients founds");
    }
}