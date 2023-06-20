package app;

import app.handlers.receiveAsync;
import app.handlers.responseAsync;
import app.models.order.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public List<Order> orders = new ArrayList<>();
    public App() throws IOException {
        new receiveAsync(this);
        new responseAsync(this);
    }
}
