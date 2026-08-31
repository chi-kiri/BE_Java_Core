package Exercise03;

public class LibraryBook {
    private static int totalBorrowed = 0;

    private String bookId;
    private String title;
    private String author;
    private boolean isBorrowed;

    public LibraryBook(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public boolean borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            totalBorrowed++;
            return true;
        } else {
            System.out.println("[Cảnh báo] Sách " + bookId + " đã được mượn.");
            return false;
        }
    }

    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            totalBorrowed--;
            return true;
        } else {
            System.out.println("[Cảnh báo] Sách " + bookId + " đang ở thư viện.");
            return false;
        }
    }

    public static int getTotalBorrowed() {
        return totalBorrowed;
    }

    public String getBookId() {
        return bookId;
    }

    public void displayBook() {
        String status = isBorrowed ? "Đang cho mượn" : "Sẵn sàng";

        System.out.printf(
                "| %-8s | %-22s | %-18s | %-14s |%n",
                bookId, title, author, status
        );
    }
}