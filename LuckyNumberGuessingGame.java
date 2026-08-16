import java.util.Scanner;

public class LuckyNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int LUCKY_NUMBER = 72;
        final int MAX_GUESSES = 5;

        int attempts = 0;
        boolean isWin = false;

        System.out.println("--- MINI-GAME: ĐOÁN SỐ MAY MẮN (Từ 1 đến 100) ---");

        while (attempts < MAX_GUESSES) {
            System.out.printf(
                    "[Lần %d/%d] Bạn đoán số mấy?: ",
                    attempts + 1,
                    MAX_GUESSES
            );

            int guess = Integer.parseInt(scanner.nextLine());

            attempts++;

            if (guess == LUCKY_NUMBER) {
                isWin = true;

                System.out.println();
                System.out.println("+=======================================================+");
                System.out.printf(
                        "|   CHÚC MỪNG! BẠN ĐÃ ĐOÁN ĐÚNG SỐ BÍ MẬT LÀ %d!      |%n",
                        LUCKY_NUMBER
                );
                System.out.printf(
                        "|   Bạn đã chiến thắng chỉ sau %d lượt dự đoán!         |%n",
                        attempts
                );
                System.out.println("+=======================================================+");

                break;
            }

            if (guess > LUCKY_NUMBER) {
                System.out.println(
                        " -> Gợi ý: Số bí mật NHỎ HƠN số bạn đoán!"
                );
            } else {
                System.out.println(
                        " -> Gợi ý: Số bí mật LỚN HƠN số bạn đoán!"
                );
            }
        }

        if (!isWin) {
            System.out.println();
            System.out.println("+=======================================================+");
            System.out.println("|                     THUA CUỘC!                       |");
            System.out.printf(
                    "|   Bạn đã dùng hết %d lượt dự đoán.                    |%n",
                    MAX_GUESSES
            );
            System.out.printf(
                    "|   Số bí mật là: %d                                    |%n",
                    LUCKY_NUMBER
            );
            System.out.println("+=======================================================+");
        }

        scanner.close();
    }
}