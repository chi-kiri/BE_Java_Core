package Exercise04;

public class Main {
    public static void main(String[] args) {
        OnlineBankingTransaction banking = new OnlineBankingTransaction();

        String pin1 = "9999";
        boolean auth1 = banking.authenticate(pin1);
        boolean transaction1 = banking.executeTransaction(2000000);

        String pin2 = "1234";
        boolean auth2 = banking.authenticate(pin2);
        boolean transaction2 = banking.executeTransaction(2000000);

        System.out.printf("""
                +-------------------------------------------------------+
                |          NHẬT KÝ BẢO MẬT GIAO DỊCH ONLINE            |
                +-------------------------------------------------------+
                | [Lần 1] PIN '%s' %s => %s
                | [Lần 2] PIN '%s' %s => %s
                | -> Số dư còn lại: %,.2f VNĐ
                +-------------------------------------------------------+
                """,
                pin1,
                auth1 ? "đúng" : "sai",
                transaction1 ? "CHUYỂN KHOẢN THÀNH CÔNG!" : "TỪ CHỐI GIAO DỊCH!",
                pin2,
                auth2 ? "đúng" : "sai",
                transaction2 ? "CHUYỂN KHOẢN THÀNH CÔNG!" : "TỪ CHỐI GIAO DỊCH!",
                banking.getBalance());
    }
}
