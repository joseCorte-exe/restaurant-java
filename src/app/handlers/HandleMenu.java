package app.handlers;

import app.classes.order.Product;

public class HandleMenu {
    private StringBuilder message = new StringBuilder();

    private StringBuilder MountMenu(Product[] products) {
        this.message.append("~~~~~~~~~~Menu~~~~~~~~~~\n");
        for (Product product : products) {
            this.message.append(" " + product.getName() + ": " + product.getPrice() + "\n");
        }
        this.message.append("~~~~~~~~~~~~~~~~~~~~~~~~\n");
        return this.message;
    }

    public HandleMenu(Product[] products) {
        MountMenu(products);
    }

    public void ViewMenu() {
        System.out.println(this.message.toString());
    }
}
