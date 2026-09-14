package Exercise05;

public class Employee implements IAppraisable {
    private String empName;
    private int kpiScore;

    public Employee(String empName, int kpiScore) {
        this.empName = empName;
        this.kpiScore = kpiScore;
    }

    @Override
    public String getRating() {
        if (kpiScore >= 80) {
            return "Xuất sắc";
        }
        return "Đạt";
    }

    public String getEmpName() {
        return empName;
    }
}
