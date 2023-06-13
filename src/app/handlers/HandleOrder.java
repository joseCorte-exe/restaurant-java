package app.handlers;

import shared.Constants;
import app.models.order.Order;
import app.models.order.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleOrder {
    private HandleMenu menu = new HandleMenu();
    Constants Constants = new Constants();

    public Order handleMakeOrder() {
        Scanner scan = new Scanner(System.in);
        int option=1;
        List<Product> products = new ArrayList<Product>();

        System.out.println("Choose a product: (by position or 0 to exit order)");
        System.out.println("you can order only 5 plate per time");

        for (int i=0; option != 0 && i < 5; i++) {
            menu.ViewMenu();
            option = scan.nextInt();

            // todo: remove trainwreck
            if (option > 0 && option <= this.Constants.getProducts().length) products.add(this.Constants.getProducts()[option-1]);
        }
        System.out.println(products.size());

        Order order = new Order(products);
        return order;
    }
}
