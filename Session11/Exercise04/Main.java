package Exercise04;

public class Main {
    public static void main(String[] args) {
        StandardAccount standardAccount =
                new StandardAccount("STD-01", 1000000);

        VIPAccount vipAccount =
                new VIPAccount("VIP-01", 5000000);

        boolean transaction1 =
                standardAccount.transfer(vipAccount, 500000);

        double stdAfterTransaction1 = standardAccount.getBalance();
        double vipAfterTransaction1 = vipAccount.getBalance();

        boolean transaction2 =
                vipAccount.transfer(standardAccount, 1000000);

        System.out.printf("""
                --- CHUYỂN KHOẢN GIỮA 2 TÀI KHOẢN ---

                +---------------------------------------------------------------+
                |              NHẬT KÝ CHUYỂN KHOẢN RIKKEI BANK                |
                +---------------------------------------------------------------+
                | [GD 1 - Standard] Chuyen 500,000 + Phi 5,000 => %s
                | -> So du STD-01: %,.0f VNĐ | VIP-01: %,.0f VNĐ
                |---------------------------------------------------------------|
                | [GD 2 - VIP] Chuyen 1,000,000 (Mien phi) => %s
                | -> So du VIP-01: %,.0f VNĐ | STD-01: %,.0f VNĐ
                +---------------------------------------------------------------+
                """,
                transaction1 ? "OK" : "FAILED",
                stdAfterTransaction1,
                vipAfterTransaction1,
                transaction2 ? "OK" : "FAILED",
                vipAccount.getBalance(),
                standardAccount.getBalance());
    }
}
