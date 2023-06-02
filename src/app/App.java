package app;

import app.classes.client.Bill;
import app.classes.client.Client;
import app.classes.order.Product;
import app.handlers.HandleMenu;
import app.seeders.Seeder;

import java.util.Scanner;

public class App {
    private Seeder seeder = new Seeder();
    private Product[] products = seeder.getProducts();

    public App() {
    }

    private HandleMenu menu = new HandleMenu(products);

    Client client = new Client(
            "Client 1",
            new Bill(),
            2
    );

    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "----------------------------\n" +
                "        1. View menu        \n" +
                "      2. Make an order      \n" +
                "        0. Finalizar        \n" +
                "##############################"
        );
        int option = scan.nextInt();
        switch(option) {
            case 1:
                menu.ViewMenu();
                break;
            case 2:
//                handleMakeOrder();
                break;
            default:
                System.out.println("choose a valid option");
                menu();
        }
    }
}
