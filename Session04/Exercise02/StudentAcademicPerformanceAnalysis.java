import java.util.Scanner;

public class StudentAcademicPerformanceAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG PHÂN TÍCH HỌC LỰC JAVA CORE ---");
        System.out.print("Nhập số lượng học viên (N): ");
        int n = Integer.parseInt(scanner.nextLine());

        double[] scores = new double[n];

        for (int i = 0; i < scores.length; i++) {
            do {
                System.out.print("Nhập điểm HV #" + i + ": ");
                scores[i] = Double.parseDouble(scanner.nextLine());

                if (scores[i] < 0 || scores[i] > 10) {
                    System.out.println("Điểm không hợp lệ. Vui lòng nhập từ 0.0 đến 10.0.");
                }
            } while (scores[i] < 0 || scores[i] > 10);
        }

        double maxScore = scores[0];
        int excellentCount = 0;
        String scoreList = "";
        String excellentList = "";

        for (int i = 0; i < n; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }

            if (scores[i] >= 8.0) {
                excellentCount++;

                if (!excellentList.isEmpty()) {
                    excellentList += " | ";
                }

                excellentList += "HV #" + i + " (" + scores[i] + ")";
            }

            scoreList += scores[i];

            if (i < n - 1) {
                scoreList += ", ";
            }
        }

        double excellentRate = (double) excellentCount / n * 100;

        System.out.printf("""
                +-------------------------------------------------------+
                |            PHÂN TÍCH KẾT QUẢ THI JAVA CORE           |
                +-------------------------------------------------------+
                | Điểm thi lớp:       [%s]
                | Điểm cao nhất:      %.2f điểm (Thủ khoa)
                | Số học viên Giỏi:   %d học viên (Tỷ lệ: %.1f%%)
                | Danh sách HV Giỏi:  %s
                +-------------------------------------------------------+
                """,
                scoreList,
                maxScore,
                excellentCount,
                excellentRate,
                excellentList
        );

        scanner.close();
    }
}