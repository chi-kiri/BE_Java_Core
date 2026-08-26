package Exercise04;

public class Student {
    String studentId;
    String fullName;
    double mathScore;
    double literatureScore;
    double englishScore;

    public Student(String studentId, String fullName, double mathScore, double literatureScore, double englishScore) {
        this.studentId = studentId;
        this.fullName = fullName;

        if (mathScore >= 0 && mathScore <= 10) {
            this.mathScore = mathScore;
        }

        if (literatureScore >= 0 && literatureScore <= 10) {
            this.literatureScore = literatureScore;
        }

        if (englishScore >= 0 && englishScore <= 10) {
            this.englishScore = englishScore;
        }
    }

    public double getAverageScore() {
        return (mathScore + literatureScore + englishScore) / 3;
    }

    public String getAcademicStanding() {
        double averageScore = getAverageScore();

        if (averageScore >= 8.0) {
            return "GIỎI (EXCELLENT)";
        } else if (averageScore >= 6.5) {
            return "KHÁ (GOOD)";
        } else if (averageScore >= 5.0) {
            return "TRUNG BÌNH (AVERAGE)";
        } else {
            return "YẾU (WEAK)";
        }
    }

    public void displayStudentProfile() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             HỒ SƠ HỌC TẬP SINH VIÊN                  |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Mã SV: %-15s | Họ tên: %-20s%n", studentId, fullName);
        System.out.printf("| Điểm thi: Toán (%.1f) | Văn (%.1f) | Anh (%.1f)%n",
                mathScore, literatureScore, englishScore);
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| ĐIỂM TRUNG BÌNH:      %.2f điểm%n", getAverageScore());
        System.out.printf("| XẾP LOẠI HỌC LỰC:     %s%n", getAcademicStanding());
        System.out.println("+-------------------------------------------------------+");
    }
}
