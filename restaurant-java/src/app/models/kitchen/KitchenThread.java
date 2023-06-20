package app.models.kitchen;

import app.models.order.Order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class KitchenThread extends Thread {
    @Override
    public void run() {
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
                System.out.println("!!notification (kitchen) -> received an order (id: " + order.id + ")");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
