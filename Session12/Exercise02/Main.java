package Exercise02;

public class Main {
    public static void main(String[] args) {
        INotifier[] notifiers = {
                new EmailNotifier(),
                new SMSNotifier()
        };

        String[] recipients = {
                "an.nguyen@rikkei.edu.vn",
                "0987654321"
        };

        String message = "Giảm 30% toàn bộ khóa học Java Core trong hôm nay!";

        System.out.println("""
                --- GỬI THÔNG BÁO KHUYẾN MÃI CRM ---

                +-------------------------------------------------------+
                |           HỆ THỐNG GỬI TIN NHẮN CRM RIKKEI           |
                +-------------------------------------------------------+
                """);

        for (int i = 0; i < notifiers.length; i++) {
            notifiers[i].sendNotification(recipients[i], message);

            if (i < notifiers.length - 1) {
                System.out.println("|-------------------------------------------------------|");
            }
        }

        System.out.println("+-------------------------------------------------------+");
    }
}
