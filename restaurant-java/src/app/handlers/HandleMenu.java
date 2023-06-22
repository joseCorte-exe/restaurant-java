package app.handlers;

import shared.Constants;
import app.models.product.Product;

import java.util.List;
import java.util.Scanner;

public class HandleMenu {
    Constants Constants = new Constants();

    private StringBuilder message = new StringBuilder();

    private StringBuilder MountMenu(List<Product> products) {
        this.message.append("~~~~~~~~~~~~~~~~\uD83C\uDF7D\uFE0FMenu\uD83C\uDF7D\uFE0F~~~~~~~~~~~~~~~~\n");
        int i=1;
        for (Product product : products) {
            this.message.append("   " + i + "." + " \uD83C\uDF5D " + product.getName() + ": $" + product.getPrice() + "\n");
            i++;
        }

        this.message.append("   5. to view products specifications\n");
        this.message.append("   0. to exit\n");
        this.message.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        return this.message;
    }

    public void ViewMenu(Boolean isOrdering) {
        System.out.println(this.message.toString());
        if (!isOrdering) {
            Scanner scan = new Scanner(System.in);
            int option;
            System.out.println("Which plate would you like to know about?");
            option = scan.nextInt();
            if (option > 0 && option < this.Constants.getProducts().size())
            System.out.println(option + ". " + this.Constants.getProducts().get(option-1).getSpecifications());
        }
    }

    public HandleMenu() {
        MountMenu(this.Constants.getProducts());
    }
}
