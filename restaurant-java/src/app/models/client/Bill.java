package app.models.client;

import app.models.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private float amount;
    private List<Order> orders = new ArrayList<Order>();
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}