package app;

import app.client.Bill;
import app.client.Client;
import app.order.Order;
import app.order.Product;

import java.util.Scanner;

public class App {
    Client client = new Client(
            "Client 1",
            new Bill(),
            2
    );

    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "----------------------------\n" +
                "       1. Make an order       " +
                "         0. Finalizar         " +
                "##############################"
        );
        int option = scan.nextInt();
        switch(option) {
            case 1:
                handleMakeOrder();
            default:
                System.out.println("choose a valid option");
                menu();
        }
    }
}
