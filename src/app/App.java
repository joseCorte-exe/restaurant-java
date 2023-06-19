package app;

import app.handlers.HandleOrder;
import app.models.client.Bill;
import app.models.client.Client;
import app.handlers.HandleMenu;
import app.models.order.Order;
import shared.Constants;

import java.util.List;
import java.util.Scanner;

public class App {
    public App() {
    }

    Constants constants = new Constants();

    private HandleMenu menu = new HandleMenu();
    private HandleOrder orderHandler = new HandleOrder();

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

        System.out.println("what is the table number? ");
        int tableNumber = scan.nextInt();

        Client client = null;
        int option=1;

        try {
            client = constants.findClient(constants.getClients(), Integer.toString(tableNumber));
        } catch (Exception err) {
            System.out.println("Create new client? (yes / no)");

            if (err.getMessage() == "not found -> no clients founds") {
                if (scan.nextLine() == "no") return;
                client = constants.addClient();
            }
        }

        viewActions();

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
