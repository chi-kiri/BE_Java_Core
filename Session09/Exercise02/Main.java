package Exercise02;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- THỬ NGHIỆM MỞ 4 KẾT NỐI SERVER ---");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             GIÁM SÁT KẾT NỐI MÁY CHỦ RIKKEI          |");
        System.out.println("+-------------------------------------------------------+");

        ServerConnection conn1 = new ServerConnection("Conn 1");
        ServerConnection conn2 = new ServerConnection("Conn 2");
        ServerConnection conn3 = new ServerConnection("Conn 3");

        System.out.println("|-------------------------------------------------------|");

        ServerConnection conn4 = new ServerConnection("Conn 4");

        System.out.println("|-------------------------------------------------------|");

        conn2.closeConnection();

        ServerConnection conn5 = new ServerConnection("Conn 5");

        System.out.println("+-------------------------------------------------------+");
    }
}
