package app.models.client;

import app.models.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private float amount;
    private boolean isPaid = false;
    static public List<Order> orders = new ArrayList<Order>();
    public float getAmount() {
        amount = orders
            .stream()
            .reduce(0, (total, order) -> (int) (total + order.getAmount()), Integer::sum);
        return amount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payBill() {
        isPaid = true;
        System.out.println(
                "\n" +
                " ▄▄▄▄▄▄▄  ▄  ▄ ▄   ▄▄▄ ▄▄  ▄▄▄▄▄▄▄\n" +
                " █ ▄▄▄ █ █▄▄██ ▄█▄▄█ ▀ ▀█  █ ▄▄▄ █\n" +
                " █ ███ █ ▄▀▀▀ ▄▀▄▄ ██▀▄▀█▀ █ ███ █\n" +
                " █▄▄▄▄▄█ █▀▄▀▄ █▀█ ▄▀▄▀▄ █ █▄▄▄▄▄█\n" +
                " ▄▄ ▄  ▄▄▀▀▄ ▀▄█ █▀▀▀ ███▄ ▄▄▄ ▄▄ \n" +
                "   ▄ ▀█▄ █▄█▀ █▀ ██▄▄█▄█ ▀ █▄ █  █\n" +
                " ▀█ ▄▄█▄▄    ▄█▀█▄  █▀█▀▀▀██▄ ▄ ▀█\n" +
                "  █▄█ █▄██▀▀▀█▀▄ ▄ ▀ ██ ▄▀█▀▄▀█▀█▀\n" +
                " ▄▀█ █ ▄▄ █▀▄▀▀  ▄█▀▄██ ▄█ ▄ █▀ ▀▄\n" +
                " ▄▄█▄██▄  ▀█  ▀▀▀▀▄▄   ▀▀ ▀▄▄▄█▀▄▄\n" +
                " ▀█▄▄█▀▄▄█ ▀█▄▄██ ▀▀▀██ ▀█▄▀█ █ ▄ \n" +
                " ▄█▄▄█▀▄ ▀█▀██▄█   ▄█▀▀▄ ▀▀█ ▄▄▀ █\n" +
                " ▄▀▀▀▀▀▄▄▀▀▀█▀▀▄██▄ █▀▀ ██▄█▄██ ▀▀\n" +
                " ▄▄▄▄▄▄▄ ██ █ █▄  █▄▀▄▀▄▀█ ▄ █  ▄▀\n" +
                " █ ▄▄▄ █  ▀ ▀▄▄ ▀▀█▀▄▀██ █▄▄▄█▄ ▄▄\n" +
                " █ ███ █ ▀▄▄▄█▀█ ██  ▄█▀▀█▀▀▀██ ██\n" +
                " █▄▄▄▄▄█ ██▀ ▀ ▀▄▄▀  ██▄▀█▀█▄▄  ▄ \n"
        );
        System.out.println("!cola o qrcode no bloco de notas pra ler");
    }
}
