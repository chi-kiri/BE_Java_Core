import java.util.Scanner;

public class ServerAccessLogAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("--- MODULE PHÂN TÍCH SERVER ACCESS LOG ---\nNhập dòng log: ");
        String logLine = scanner.nextLine();

        int startTimestamp = logLine.indexOf("[");
        int endTimestamp = logLine.indexOf("]");

        int startIp = logLine.indexOf("IP: ") + 4;
        int endIp = logLine.indexOf(" |", startIp);

        int startStatus = logLine.indexOf("STATUS: ") + 8;
        int endStatus = logLine.indexOf(" |", startStatus);

        int startMessage = logLine.indexOf("MSG: ") + 5;

        String timestamp = logLine.substring(startTimestamp + 1, endTimestamp);
        String ipAddress = logLine.substring(startIp, endIp);
        int statusCode = Integer.parseInt(logLine.substring(startStatus, endStatus));
        String message = logLine.substring(startMessage);

        boolean isError = logLine.contains("ERROR") || statusCode >= 400;

        System.out.printf("""
                +-------------------------------------------------------+
                |             BÁO CÁO TRÍCH XUẤT NHẬT KÝ LOG           |
                +-------------------------------------------------------+
                | Thời gian (Timestamp):  %s
                | Địa chỉ Client IP:      %s
                | HTTP Status Code:       %d
                | Nội dung thông điệp:    %s
                |-------------------------------------------------------|
                | CẢNH BÁO HỆ THỐNG:      %s
                +-------------------------------------------------------+
                """,
                timestamp,
                ipAddress,
                statusCode,
                message,
                isError
                        ? "PHÁT HIỆN LỖI TRUY CẬP (" + statusCode + ")"
                        : "HỆ THỐNG HOẠT ĐỘNG BÌNH THƯỜNG");

        scanner.close();
    }
}