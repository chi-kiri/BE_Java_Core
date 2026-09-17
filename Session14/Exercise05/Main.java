package Exercise05;

public class Main {
    public static void main(String[] args) {

        UIController controller = new UIController();

        System.out.println("--- LAN TRUYỀN NGOẠI LỆ CONFIG LOADER ---");

        System.out.println("Lần 1: Nạp file \"config/app.ini\"");
        controller.initSystem("config/app.ini");

        System.out.println();

        System.out.println("Lần 2: Nạp file \"config/invalid_app.ini\"");
        controller.initSystem("config/invalid_app.ini");
    }
}
