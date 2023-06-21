package app.models.kitchen;

import app.models.order.Order;
import app.models.waiter.Waiter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class KitchenThread extends Thread {
    @Override
    public void run() {
        Waiter waiter = new Waiter();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3334);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                System.out.println("!!notification (kitchen) -> \uD83D\uDC68\u200D\uD83C\uDF73 received an order from kitchen (id: " + order.id + ")");
                waiter.deliverOrderToClient(order);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
