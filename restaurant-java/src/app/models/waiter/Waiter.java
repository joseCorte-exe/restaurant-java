package app.models.waiter;

import app.models.order.Order;
import app.services.OrderService;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Waiter {
    static public String status;
    OrderService service = new OrderService();

    public void addOrderToKitchen(Order order) throws IOException {
        System.out.println("!!notification (waiter) -> adding order to prepare - " + order.getId());

        service.addOrder(order);
    }

    public void getOrderToClient() {
        try {
            this.status = "busy";
            Thread.sleep(3000);
            System.out.println("!!notification (waiter) -> order delivered");
            this.status = "free";
        } catch (Exception e) {}
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        Waiter.status = status;
    }
}
