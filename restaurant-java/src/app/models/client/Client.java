package app.models.client;

import app.models.order.Order;
import app.models.product.Product;

import java.util.List;
import java.util.UUID;

public class Client extends Bill {
    private UUID id;
    private String name;
    static public Bill bill;
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

    public Bill getBill() {
        List<Order> orders = this.getOrders();
        if (orders.isEmpty())
            System.out.println("No orders");
        else {
            System.out.println("\n|===================\uD83D\uDDD2\uFE0FBill\uD83D\uDDD2\uFE0F===================|");
            for (Order order : orders) {
                List<Product> products = order.getProducts();
                System.out.println("| Order: " + order.getId().toString().strip() + " |");
                System.out.println("|              status: " + order.getStatus() + "              |");
                for (int i=0; i < order.getProducts().size(); i++) {
                    Product product = products.get(i);
                    System.out.println("|       Product: " + product.getName() + " | price:" + product.getPrice() + "        |");
                }
                System.out.println("|---------------------------------------------|");
            }
            System.out.println("|=============================================|\n");
        }
        return bill;
    }
    public int getTable() {
        return table;
    }
}
