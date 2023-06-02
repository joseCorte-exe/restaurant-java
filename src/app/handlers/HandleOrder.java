package app.handlers;

import DB.DB;
import app.classes.order.Order;
import app.classes.order.Product;

import java.awt.*;
import java.util.Scanner;

public class HandleOrder {
    DB DB = new DB();
    private HandleMenu menu = new HandleMenu();
    public Order handleMakeOrder() {
        Scanner scan = new Scanner(System.in);
        int option=1;
        Product[] products = new Product[5];

        System.out.println("Choose a product: (by number)");
        for (int i=0; option != 0 && i <=5; i++) {
            menu.ViewMenu();
            option = scan.nextInt();

        }

        Order order = new Order(products);
        return order;
    }
}
