package Exercise01;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Arthur", 500);
        Mage mage = new Mage("Merlin", 300);

        System.out.println("""
                --- KHỞI TẠO 2 NHÂN VẬT GAME ---

                +-------------------------------------------------------+
                |             ĐẤU TRƯỜNG NHÂN VẬT RIKKEI RPG           |
                +-------------------------------------------------------+
                """);

        warrior.attack();
        mage.attack();

        System.out.println(
                "+-------------------------------------------------------+"
        );
    }
}
