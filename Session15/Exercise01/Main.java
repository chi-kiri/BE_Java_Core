package Exercise01;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MovieManager<Movie> manager = new MovieManager<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Chọn chức năng:
                    1. Thêm phim
                    2. Xóa phim
                    3. Sửa phim
                    4. Hiển thị phim
                    5. Tìm kiếm phim theo tên
                    6. Lọc phim theo rating
                    7. Thoát
                    """);

            int choice = inputInteger("Chọn: ");

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    deleteMovie();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    manager.displayMovies();
                    break;
                case 5:
                    searchMovie();
                    break;
                case 6:
                    filterMovie();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }

    public static void addMovie() {
        int id = inputInteger("Nhập ID phim: ");

        if (manager.findById(id) != null) {
            System.out.println("ID phim đã tồn tại!");
            return;
        }

        System.out.print("Nhập tiêu đề phim: ");
        String title = scanner.nextLine();

        System.out.print("Nhập đạo diễn: ");
        String director = scanner.nextLine();

        LocalDate releaseDate = inputDate("Nhập ngày phát hành (yyyy-MM-dd): ");

        double rating = inputRating("Nhập rating: ");

        Movie movie = new Movie(id, title, director, releaseDate, rating);

        manager.addMovie(movie);

        System.out.println("Phim đã được thêm thành công.");
    }

    public static void deleteMovie() {
        int id = inputInteger("Nhập ID phim cần xóa: ");

        if (manager.deleteMovie(id)) {
            System.out.println("Phim đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy phim muốn xóa!");
        }
    }

    public static void updateMovie() {
        int id = inputInteger("Mời nhập id phim muốn sửa: ");

        Movie movie = manager.findById(id);

        if (movie == null) {
            System.out.println("Không tìm thấy phim với id = " + id);
            return;
        }

        System.out.print("Nhập tiêu đề phim: ");
        String title = scanner.nextLine();

        System.out.print("Nhập đạo diễn: ");
        String director = scanner.nextLine();

        LocalDate releaseDate = inputDate("Nhập ngày phát hành (yyyy-MM-dd): ");

        double rating = inputRating("Nhập rating: ");

        movie.setTitle(title);
        movie.setDirector(director);
        movie.setReleaseDate(releaseDate);
        movie.setRating(rating);

        System.out.println("Cập nhật phim thành công!");
    }

    public static void searchMovie() {
        System.out.print("Nhập tiêu đề phim để tìm kiếm: ");
        String title = scanner.nextLine();

        manager.searchByTitle(title);
    }

    public static void filterMovie() {
        double rating = inputRating("Nhập rating tối thiểu để lọc: ");

        manager.filterByRating(rating);
    }

    public static int inputInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số nguyên!");
            }
        }
    }

    public static double inputRating(String message) {
        while (true) {
            try {
                System.out.print(message);
                double rating = Double.parseDouble(scanner.nextLine());

                if (rating < 0 || rating > 10) {
                    System.out.println("Rating phải nằm trong khoảng từ 0 đến 10!");
                    continue;
                }

                return rating;
            } catch (NumberFormatException e) {
                System.out.println("Rating không hợp lệ, vui lòng nhập số!");
            }
        }
    }

    public static LocalDate inputDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập theo yyyy-MM-dd!");
            }
        }
    }
}
