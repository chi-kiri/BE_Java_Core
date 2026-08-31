package Exercise03;

public class Main {
    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook(
                "BK-01",
                "Lập trình Java Core",
                "Nguyễn Văn A"
        );

        LibraryBook book2 = new LibraryBook(
                "BK-02",
                "Cấu trúc dữ liệu",
                "Trần Văn B"
        );

        System.out.println("--- THỬ NGHIỆM MƯỢN TRẢ SÁCH THƯ VIỆN ---");

        boolean borrow1 = book1.borrowBook();
        int total1 = LibraryBook.getTotalBorrowed();

        boolean borrow2 = book2.borrowBook();
        int total2 = LibraryBook.getTotalBorrowed();

        boolean return1 = book1.returnBook();
        int total3 = LibraryBook.getTotalBorrowed();

        System.out.printf("""
                +-------------------------------------------------------+
                |             QUẢN LÝ MƯỢN TRẢ SÁCH THƯ VIỆN           |
                +-------------------------------------------------------+
                | [Mượn BK-01] %s -> Tổng sách đang mượn: %d
                | [Mượn BK-02] %s -> Tổng sách đang mượn: %d
                | [Trả  BK-01] %s -> Tổng sách đang mượn: %d
                |-------------------------------------------------------|
                | Thống kê: Còn lại %d sách đang được độc giả mượn
                +-------------------------------------------------------+
                """,
                borrow1 ? "Thành công!" : "Thất bại!",
                total1,
                borrow2 ? "Thành công!" : "Thất bại!",
                total2,
                return1 ? "Thành công!" : "Thất bại!",
                total3,
                LibraryBook.getTotalBorrowed()
        );
    }
}
