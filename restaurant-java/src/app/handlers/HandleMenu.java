package app.handlers;

import shared.Constants;
import app.models.product.Product;

public class HandleMenu {
    Constants Constants = new Constants();

    private StringBuilder message = new StringBuilder();

    private StringBuilder MountMenu(Product[] products) {
        this.message.append("~~~~~~~~~~\uD83C\uDF7D\uFE0FMenu\uD83C\uDF7D\uFE0F~~~~~~~~~~\n");
        int i=1;
        for (Product product : products) {
            this.message.append("   " + i + "." + " \uD83C\uDF5D " + product.getName() + ": $" + product.getPrice() + "\n");
            i++;
        }
        this.message.append("   0. to exit\n");
        this.message.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        return this.message;
    }

    public void ViewMenu() {
        System.out.println(this.message.toString());
    }

    public HandleMenu() {
        MountMenu(this.Constants.getProducts());
    }
}
