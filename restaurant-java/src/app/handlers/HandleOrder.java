package app.handlers;

import app.models.waiter.Waiter;
import shared.Constants;
import app.models.order.Order;
import app.models.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        int i=0;
        while (option != 0 && i < 5) {
            menu.ViewMenu(true);
            option = scan.nextInt();

            if (option == 5) {
                System.out.println("Which plate would you like to know about?");
                option = scan.nextInt();
                System.out.println(this.Constants.getProducts().get(option-1).getSpecifications());
            }
            // todo: remove train wreck
            else if (option > 0 && option <= this.Constants.getProducts().size()) {
                products.add(this.Constants.getProducts().get(option - 1));
                System.out.println("Quantity: ");
                int quantity;
                quantity = scan.nextInt();
                products.get(i).setAmount(quantity);
                i++;
            }
        }
        System.out.println("plates quantity: " + products.size());

        System.out.println("Add some preferences? (1 for yes, 0 for no)");
        String preferences = "";
        int o = scan.nextInt();

        if (o == 1) {
            Scanner scanString = new Scanner(System.in);
            System.out.println("What are your preferences?");
            preferences = scanString.nextLine();
        }

        Order order = new Order(products, preferences);

        waiter.addOrderToKitchen(order);

        return order;
    }
}
