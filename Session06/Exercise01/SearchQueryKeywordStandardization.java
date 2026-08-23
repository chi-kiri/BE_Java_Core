import java.util.Scanner;

public class SearchQueryKeywordStandardization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("--- HỆ THỐNG LÀM SẠCH TỪ KHÓA TRUY VẤN ---\nNhập chuỗi truy vấn thô: ");
        String rawQuery = scanner.nextLine();

        String cleanedQuery = rawQuery
                .replaceAll("[^a-zA-Z0-9\\s]", " ")
                .toLowerCase()
                .trim();

        String[] words;

        if (cleanedQuery.isEmpty()) {
            words = new String[0];
        } else {
            words = cleanedQuery.split("\\s+");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(String.format(
                    "| [%d] %-18s (%d ký tự)%n",
                    i + 1,
                    words[i],
                    words[i].length()
            ));
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |             KẾT QUẢ LÀM SẠCH TỪ KHÓA SEO             |
                +-------------------------------------------------------+
                | Chuỗi truy vấn gốc: [%s]
                | Số từ khóa hợp lệ:  %d từ khóa
                |-------------------------------------------------------|
                %s+-------------------------------------------------------+
                """,
                rawQuery,
                words.length,
                result);

        scanner.close();
    }
}