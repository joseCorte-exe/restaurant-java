package app.services;

import app.models.order.Order;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class OrderService {
    public void addOrder(Order order) throws IOException {
        send(order);
    }

    public static void send(Order order) throws IOException {
        Socket socket = new Socket("localhost", 3333);
        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            output.writeObject(order);

            Thread.sleep(2000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
