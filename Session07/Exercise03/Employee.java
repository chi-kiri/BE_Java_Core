package Exercise03;

public class Employee {
    String empId;
    String empName;
    double baseSalary;
    double rate;
    double allowance;

    public Employee(String empId, String empName, double baseSalary, double rate, double allowance) {
        this.empId = empId;
        this.empName = empName;
        this.baseSalary = baseSalary;
        this.rate = rate;
        this.allowance = allowance;
    }

    public double calculateTotalSalary() {
        return baseSalary * rate + allowance;
    }

    public void displayPayrollTicket() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             PHIẾU LƯƠNG NHÂN VIÊN RIKKEI             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Mã NV: %-13s | Họ tên: %-20s%n", empId, empName);
        System.out.printf("| Lương cơ bản: %,.2f VNĐ | Hệ số: %.2f%n", baseSalary, rate);
        System.out.printf("| Phụ cấp:      %,.2f VNĐ%n", allowance);
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| -> THU NHẬP THỰC LĨNH: %,.2f VNĐ%n", calculateTotalSalary());
        System.out.println("+-------------------------------------------------------+");
    }
}