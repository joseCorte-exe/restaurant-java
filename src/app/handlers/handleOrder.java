package app.handlers;

import app.order.Order;
import app.order.Product;

import java.util.Scanner;

public class handleOrder {
    public handleProducts(Product[] products, int option) {
        products[products.length] =
        for ( int i=0; i<=products.length; i++ ) {
            if (i <= products.length) {

            }
            products[i] = new Product();
        }
    }
    public Order handleMakeOrder() {
        Scanner scan = new Scanner(System.in);
        int option=1;
        Product[] products;

        while (option != 0) {
            System.out.println(
                "----------------------------\n" +
                "       1. Make an order       " +
                "         0. Finalizar         " +
                "##############################"
            );
            option = scan.nextInt();
            products.
        }

        Order order = new Order(products);
        return order;
    }
}
