import app.models.kitchen.KitchenThread;
import shared.Constants;
import app.App;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Constants();
        new KitchenThread().start();
        App app = new App();

        app.menu();
    }
}
