package app.handlers;

import app.App;
import app.models.order.Order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class receiveAsync {
    public receiveAsync(App app) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        Runnable r = () -> {
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    ObjectInputStream inputReader = new ObjectInputStream(socket.getInputStream());
                    Order order = (Order) inputReader.readObject();
                    System.out.println("!!notification (kitchen) -> received an order (id: " + order.id + ")");

                    app.orders.add(order);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        new Thread(r).start();
    }
}
