import java.util.Scanner;

public class PalindromeStringVerification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("--- CÔNG CỤ KIỂM TRA CHUỖI ĐỐI XỨNG PALINDROME ---\nNhập chuỗi văn bản: ");
        String inputText = scanner.nextLine();

        String cleanedText = inputText.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        StringBuilder sb = new StringBuilder(cleanedText);
        String reversedText = sb.reverse().toString();

        boolean isPalindrome = cleanedText.equals(reversedText);

        System.out.printf("""
                +-------------------------------------------------------+
                |           KẾT QUẢ PHÂN TÍCH CHUỖI ĐỐI XỨNG           |
                +-------------------------------------------------------+
                | Chuỗi gốc:          %s
                | Chuỗi làm sạch:     %s
                | Chuỗi đảo ngược:    %s
                |-------------------------------------------------------|
                | KẾT LUẬN: %s
                +-------------------------------------------------------+
                """,
                inputText,
                cleanedText,
                reversedText,
                isPalindrome
                        ? "LÀ CHUỖI ĐỐI XỨNG PALINDROME HOÀN HẢO"
                        : "KHÔNG PHẢI CHUỖI ĐỐI XỨNG PALINDROME");

        scanner.close();
    }
}