package app.handlers;

import app.models.waiter.Waiter;
import shared.Constants;
import app.models.order.Order;
import app.models.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleOrder {
    private HandleMenu menu = new HandleMenu();
    Constants Constants = new Constants();
    Waiter waiter;

    public HandleOrder(Waiter waiter) {
        this.waiter = waiter;
    }

    public Order handleMakeOrder() throws Exception {
        if (waiter.status == "busy") {
            System.out.println("!!notification (handleOrder) -> Waiter is busy");
            throw new Exception("waiter is busy");
        }
        Scanner scan = new Scanner(System.in);
        int option=-1;
        List<Product> products = new ArrayList<>();

        System.out.println("Choose a product: (by position or 0 to exit order)");
        System.out.println("you can order only 5 plate per time");

        for (int i=0; option != 0 && i < 5; i++) {
            menu.ViewMenu(true);
            option = scan.nextInt();

            if (option == 5) {
                System.out.println("Which plate would you like to know about?");
                option = scan.nextInt();
                System.out.println(this.Constants.getProducts().get(option-1).getSpecifications());
            }
            // todo: remove train wreck
            else if (option > 0 && option <= this.Constants.getProducts().size()) products.add(this.Constants.getProducts().get(option-1));
        }
        System.out.println(products.size());

        Order order = new Order(products);

        waiter.addOrderToKitchen(order);

        return order;
    }
}
