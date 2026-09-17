package Exercise03;

public class Main {

    public static void main(String[] args) {

        ReportExporter exporter = new ReportExporter();

        System.out.println("--- THỬ NGHIỆM EXPORT REPORT VỚI FINALLY ---");

        System.out.println("\n[Lần 1 - Thành công]");
        exporter.exportReport(false);

        System.out.println("\n[Lần 2 - Gặp sự cố mạng]");
        exporter.exportReport(true);
    }
}
