package Exercise03;

public class Main {
    public static void main(String[] args) {
        BonusCalculator calculator = new BonusCalculator();

        double salary = 10000000;
        double performanceRate = 1.5;
        int seniorityYears = 4;

        double bonus1 = calculator.calculateBonus(salary);
        double bonus2 = calculator.calculateBonus(salary, performanceRate);
        double bonus3 = calculator.calculateBonus(salary, performanceRate, seniorityYears);

        System.out.printf("""
                --- TÍNH THƯỞNG NHÂN VIÊN RIKKEI HR ---

                +-------------------------------------------------------+
                |             BÁO CÁO TIỀN THƯỞNG CUỐI NĂM             |
                +-------------------------------------------------------+
                | Lương cơ bản chuẩn:      %,.2f VNĐ
                |-------------------------------------------------------|
                | [TH1 - Cố định 10%%]:     %,.2f VNĐ
                | [TH2 - Theo KPI 1.5]:    %,.2f VNĐ
                | [TH3 - KPI + 4 năm]:     %,.2f VNĐ
                +-------------------------------------------------------+
                """,
                salary,
                bonus1,
                bonus2,
                bonus3);
    }
}
