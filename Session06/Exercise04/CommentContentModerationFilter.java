import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentContentModerationFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = {"scam", "hack", "spam", "fake"};

        System.out.print("--- HỆ THỐNG KIỂM DUYỆT BÌNH LUẬN TỰ ĐỘNG ---\nNhập bình luận: ");
        String comment = scanner.nextLine();

        String regex = "(?i)\\b(scam|hack|spam|fake)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(comment);

        int count = 0;
        StringBuilder violatedWords = new StringBuilder();

        while (matcher.find()) {
            count++;

            if (violatedWords.length() > 0) {
                violatedWords.append(", ");
            }

            violatedWords.append(matcher.group().toLowerCase());
        }

        String sanitizedComment = comment.replaceAll(regex, "***");

        String warning = count >= 2
                ? "GẮN CỜ VI PHẠM (Phát hiện >= 2 từ)"
                : "KHÔNG CÓ CẢNH BÁO";

        System.out.printf("""
                +-------------------------------------------------------+
                |             KẾT QUẢ KIỂM DUYỆT NỘI DUNG              |
                +-------------------------------------------------------+
                | Bình luận gốc:      %s
                | Số từ vi phạm:      %d từ khóa (%s)
                | Bình luận sạch:     %s
                |-------------------------------------------------------|
                | CẢNH BÁO TÀI KHOẢN: %s
                +-------------------------------------------------------+
                """,
                comment,
                count,
                violatedWords,
                sanitizedComment,
                warning);

        scanner.close();
    }
}