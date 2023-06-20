package app.handlers;

import app.App;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class responseAsync {
    public responseAsync(App app) {
        Runnable r = () -> {
            while (true) {
                if (app.orders.size() > 0) {
                    Socket socket = null;
                    try {
                        socket = new Socket("localhost", 3334);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("!!notification (kitchen) -> order " + app.orders.get(0).id + " got to prepare");

                    try {
                        Thread.sleep(6000);

                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(app.orders.get(0));
                        app.orders.remove(0);

                        System.out.println("!!notification (kitchen) -> order ready");
                    } catch (Exception e) {
                        System.out.println(e);
                    };
                }
            }
        };
        new Thread(r).start();
    }
}
