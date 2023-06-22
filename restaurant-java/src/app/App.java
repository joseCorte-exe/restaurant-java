package app;

import app.handlers.HandleOrder;
import app.models.client.Client;
import app.handlers.HandleMenu;
import app.models.waiter.Waiter;
import shared.Constants;

import java.util.Scanner;

public class App {
    public App() {
    }

    Waiter waiter = new Waiter();
    Constants constants = new Constants();

    private HandleMenu menu = new HandleMenu();
    private HandleOrder orderHandler = new HandleOrder(waiter);
    public void viewActions() {
        System.out.println(
            "_______________________________\n" +
            "|    1. \uD83D\uDC40 View menu          |\n" +
            "|    2. \uD83C\uDF7D\uFE0F Make an order      |\n" +
            "|    3. \uD83D\uDDD2\uFE0F View client Bill   |\n" +
            "|    4. \uD83D\uDDD2\uFE0F Pay the Bill       |\n" +
            "|    0. ✅ Finalizar          |\n" +
            "-------------------------------"
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

        while (option != 0 && option != 4) {
            viewActions();
            option = scan.nextInt();
            if (option == 0 && !client.isPaid()) {
                System.out.println("please pay the bill before leaving");
                option = -1;
            }
            switch(option) {
                case 1:
                    menu.ViewMenu(false);
                    break;
                case 2:
                    try {
                        client.addOrder(orderHandler.handleMakeOrder());
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    client.getBill();
                    break;
                case 4:
                    System.out.println(client.getAmount());
                    client.payBill();
                    break;
                default:
                    System.out.println("choose a valid option");
            }
        }
        menu();
    }
}
