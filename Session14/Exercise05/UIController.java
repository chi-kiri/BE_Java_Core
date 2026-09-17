package Exercise05;

import java.io.IOException;

public class UIController {

    public void initSystem(String path) {
        try {
            ConfigLoader.loadConfigFile(path);
        } catch (IOException e) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|          KHỞI TẠO CẤU HÌNH HỆ THỐNG UI              |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("| [Cảnh báo UI Controller]                              |");
            System.out.println("| -> Lỗi I/O: " + e.getMessage());
            System.out.println("+-------------------------------------------------------+");
        }
    }
}
