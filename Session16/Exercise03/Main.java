package Exercise03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Supplier<String> timeSupplier =
                () -> LocalDateTime.now().format(formatter);

        Consumer<String> logger =
                msg -> System.out.println("| -> " + msg);

        System.out.println(
                "+-------------------------------------------------------+\n" +
                        "|          NHẬT KÝ HỆ THỐNG CONSUMER-SUPPLIER          |\n" +
                        "+-------------------------------------------------------+"
        );

        AuditLogger.logEvent(timeSupplier, logger, "USER_LOGIN");
        AuditLogger.logEvent(timeSupplier, logger, "UPDATE_DATABASE");
        AuditLogger.logEvent(timeSupplier, logger, "SYSTEM_BACKUP");

        System.out.println(
                "+-------------------------------------------------------+"
        );
    }
}