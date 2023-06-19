package app.models.client;

import app.handlers.HandleOrder;
import app.models.order.Order;
import app.models.order.Product;

import java.util.List;
import java.util.UUID;

public class Client extends Bill {
    private UUID id;
    private String name;
    private Bill bill;
    private int table;

    public Client(
            String name,
            Bill bill,
            int table
    ) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bill = new Bill();
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bill getBill() {
        List<Order> orders = this.getOrders();
        if (orders.isEmpty())
            System.out.println("No orders");
        else {
            System.out.println("\n|===========Bill===========|\n");
            for (Order order : orders) {
                List<Product> products = order.getProducts();
                System.out.println("\n| Order:\n" + order.getId().toString().strip() + " |");

                for (int i=0; i < order.getProducts().size(); i++) {
                    Product product = products.get(i);
                    System.out.println("\n{ Product:" + product.getName() + " | price:" + product.getPrice() + " }");
                }
            }
        }
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}