import java.util.Scanner;

public class StringPerformanceBenchmarkTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lần lặp: ");
        int n = Integer.parseInt(scanner.nextLine());

        long start = System.currentTimeMillis();

        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a";
        }

        long end = System.currentTimeMillis();
        long timeString = end - start;

        str = null;
        System.gc();

        start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        end = System.currentTimeMillis();
        long timeStringBuilder = end - start;

        start = System.currentTimeMillis();

        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }

        end = System.currentTimeMillis();
        long timeStringBuffer = end - start;

        System.out.printf("""
                --- BENCHMARK CÔNG CỤ NỐI CHUỖI BIG DATA (%,d LẦN) ---

                +------------------------------------------------------------+
                |              BẢNG BENCHMARK HIỆU NĂNG STRING              |
                +------------------------------------------------------------+
                | Lớp String (Toán tử +=):     %,6d ms (Chậm nhất)          |
                | Lớp StringBuilder (.append): %,6d ms (Nhanh nhất)         |
                | Lớp StringBuffer (.append):  %,6d ms (Đồng bộ thread)     |
                |------------------------------------------------------------|
                | KHUYẾN NGHỊ: Sử dụng StringBuilder cho vòng lặp đơn       |
                +------------------------------------------------------------+
                """, n, timeString, timeStringBuilder, timeStringBuffer);

        scanner.close();
    }
}