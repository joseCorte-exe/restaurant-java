import DB.DB;
import app.App;

public class Main {
    public static void main(String[] args) {
        DB DB = new DB();
        App app = new App();

        app.menu();
    }
}