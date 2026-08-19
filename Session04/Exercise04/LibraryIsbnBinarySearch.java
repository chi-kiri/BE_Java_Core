import java.util.Scanner;

public class LibraryIsbnBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] isbnList = {101, 105, 110, 125, 140, 155, 170, 188, 195, 200};

        String isbn = "";
        for (int i = 0; i < isbnList.length; i++) {
            isbn += isbnList[i];

            if (i < isbnList.length - 1) {
                isbn += ", ";
            }
        }

        System.out.printf("""
                --- HỆ THỐNG TRA CỨU SÁCH ISBN THƯ VIỆN QUỐC GIA ---
                Danh mục ISBN: [%s]
                Nhập mã ISBN cần tra cứu: 
                """, isbn);

        int targetIsbn = Integer.parseInt(scanner.nextLine());

        int left = 0;
        int right = isbnList.length - 1;
        int index = -1;
        int steps = 0;

        while (left <= right) {
            steps++;

            int mid = left + (right - left) / 2;

            if (isbnList[mid] == targetIsbn) {
                index = mid;
                break;
            } else if (isbnList[mid] < targetIsbn) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        String status;
        String position;

        if (index != -1) {
            status = "TÌM THẤY TRÊN KỆ SÁCH";
            position = "Kệ số #" + index + " (Index " + index + ")";
        } else {
            status = "KHÔNG TÌM THẤY";
            position = "Không tồn tại";
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |             KẾT QUẢ TRA CỨU NHỊ PHÂN ISBN            |
                +-------------------------------------------------------+
                | Mã ISBN tra cứu:     %-32d|
                | Trạng thái:          %-32s|
                | Vị trí lưu trữ:      %-32s|
                | Hiệu năng tìm kiếm:  Hoàn thành sau %d bước chia đôi
                +-------------------------------------------------------+
                """,
                targetIsbn,
                status,
                position,
                steps
        );

        scanner.close();
    }
}