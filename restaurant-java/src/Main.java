import app.models.kitchen.KitchenThread;
import app.models.product.Product;
import shared.Constants;
import app.App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        new Constants();
        new KitchenThread().start();
        App app = new App();

        app.menu();
    }
}
