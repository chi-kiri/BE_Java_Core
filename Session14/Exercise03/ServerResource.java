package Exercise03;

public class ServerResource {

    public void open() {
        System.out.println("-> [ServerResource] Đang mở kết nối máy chủ...");
    }

    public void writeData(boolean triggerError) {
        if (triggerError) {
            throw new RuntimeException("Mất kết nối mạng ngẫu nhiên!");
        }

        System.out.println("-> [ServerResource] Ghi dữ liệu báo cáo thành công.");
    }

    public void close() {
        System.out.println("-> [ServerResource] ĐÃ ĐÓNG KẾT NỐI AN TOÀN (Finally)");
    }
}
