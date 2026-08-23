import java.util.Arrays;
import java.util.Scanner;

public class WarehouseSkuBinarySearchTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] skuList = {"SKU-A01", "SKU-B12", "SKU-C05", "SKU-D88", "SKU-E33", "SKU-F90", "SKU-G11"};

        System.out.print("--- HỆ THỐNG TRA CỨU NHỊ PHẦN KHO LẠNH SKU ---\nDanh mục SKU: "
                + Arrays.toString(skuList)
                + "\nNhập mã SKU cần tìm: ");

        String targetSku = scanner.nextLine().toUpperCase().trim();

        int left = 0;
        int right = skuList.length - 1;
        int foundIndex = -1;
        int steps = 0;

        while (left <= right) {
            steps++;

            int mid = left + (right - left) / 2;
            int cmp = skuList[mid].compareTo(targetSku);

            if (cmp == 0) {
                foundIndex = mid;
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        String status;
        String position;

        if (foundIndex != -1) {
            status = "TÌM THẤY TRONG DANH MỤC";
            position = "Kệ số #" + foundIndex + " (Index " + foundIndex + ")";
        } else {
            status = "KHÔNG TÌM THẤY TRONG DANH MỤC";
            position = "Không xác định";
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |             KẾT QUẢ TRA CỨU NHỊ PHẦN SKU             |
                +-------------------------------------------------------+
                | Mã tra cứu:         %-32s|
                | Trạng thái:         %-32s|
                | Vị trí kệ lạnh:     %-32s|
                | Hiệu năng tìm kiếm: Hoàn thành sau %d bước chia đôi
                +-------------------------------------------------------+
                """, targetSku, status, position, steps);

        scanner.close();
    }
}