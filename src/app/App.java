package app;

import app.handlers.HandleOrder;
import app.models.client.Bill;
import app.models.client.Client;
import app.handlers.HandleMenu;
import app.models.order.Order;

import java.util.Scanner;

public class App {
    public App() {
    }

    private HandleMenu menu = new HandleMenu();
    private HandleOrder orderHandler = new HandleOrder();

    Client client = new Client(
            "Client 1",
            new Bill(),
            2
    );

    public void viewActions() {
        System.out.println(
            "----------------------------\n" +
            "        1. View menu        \n" +
            "      2. Make an order      \n" +
            "     3. View client Bill    \n" +
            "        0. Finalizar        \n" +
            "##############################"
        );
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);
        viewActions();

        int option=1;
        while (option != 0) {
             option = scan.nextInt();
            switch(option) {
                case 1:
                    menu.ViewMenu();
                    break;
                case 2:
                    client.addOrder(orderHandler.handleMakeOrder());
                    break;
                case 3:
                    client.getBill();
                    break;
                default:
                    System.out.println("choose a valid option");
            }
            viewActions();
        }
    }
}
