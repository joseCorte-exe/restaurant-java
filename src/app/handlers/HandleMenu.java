package app.handlers;

import DB.DB;
import app.classes.order.Product;

public class HandleMenu {
    DB DB = new DB();

    private StringBuilder message = new StringBuilder();

    private StringBuilder MountMenu(Product[] products) {
        this.message.append("~~~~~~~~~~Menu~~~~~~~~~~\n");
        for (Product product : products) {
            this.message.append(" " + product.getName() + ": " + product.getPrice() + "\n");
        }
        this.message.append("~~~~~~~~~~~~~~~~~~~~~~~~\n");
        return this.message;
    }

    public HandleMenu() {
        MountMenu(DB.getProducts());
    }

    public void ViewMenu() {
        System.out.println(this.message.toString());
    }
}
