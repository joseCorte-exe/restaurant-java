package app.models.waiter;

import app.models.client.Client;
import app.models.order.Order;
import app.services.OrderService;

import java.io.IOException;

public class Waiter {
    static public String status;
    OrderService service = new OrderService();

    public void addOrderToKitchen(Order order) throws IOException {
        System.out.println("!!notification (waiter) -> \uD83D\uDC27 adding order to prepare - " + order.getId());

        service.addOrder(order);
    }

    public void deliverOrderToClient(Order order) {
        try {
            this.status = "busy";
            Thread.sleep(3000);
            order.setStatus("delivered");
            System.out.println("!!notification (waiter) -> \uD83D\uDCE6 order delivered");
            for (int i=0; i < Client.orders.size(); i++) {
                if (order.id == Client.orders.get(i).id)
                    Client.orders.get(i).setStatus("prepared");
            }
            order.setStatus("delivered");
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
