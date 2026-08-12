import java.util.Scanner;

public class HRPayrollCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã nhân viên: ");
        String employeeID = sc.nextLine();

        System.out.print("Nhập họ và tên nhân viên: ");
        String employeeName = sc.nextLine();

        System.out.print("Nhập số giờ làm việc: ");
        double workingHours = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập múc lương theo giờ: ");
        double hourlyWage = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập phụ cấp hàng tháng: ");
        double monthlyAllowance = Double.parseDouble(sc.nextLine());

        double basicSalary = workingHours * hourlyWage;
        double grossSalary = basicSalary + monthlyAllowance;
        double socialInsurance = basicSalary * 0.08;
        double healthInsurance = basicSalary * 0.015;
        double unimploymentInsurance = basicSalary * 0.01;
        double unionFee = 150000;

        double totalDeduction = socialInsurance + healthInsurance + unimploymentInsurance + unionFee;
        double netPay = grossSalary - totalDeduction;

        System.out.printf("""
                +-------------------------------------------------------------------+
                |               PHIẾU LƯƠNG NHÂN VIÊN (PAYROLL SLIP)                |
                +-------------------------------------------------------------------+
                | Mã nhân viên   : %-30s                                            |
                | Họ và tên      : %-30s                                            |
                | Số giờ làm việc: %.1f giờ  | Lương giờ:         %.2f VNĐ          |
                +-------------------------------------------------------------------+
                | I. THU NHẬP (EARNINGS)                                            |
                | - Lương cơ bản theo giờ               :        %.2f VNĐ           |
                | - Phụ cấp cố định                     :         %.2f VNĐ          |
                | -> TỔNG THU NHẬP GỘP (GROSS)          :        %.2f VNĐ           |
                +-------------------------------------------------------------------+
                | II. KHẤU TRỪ BẢO HIỂM & ĐOÀN PHÍ (DEDUCTIONS)                     |
                | - BHXH (8.0%%)                         :         %.2f VNĐ          |
                | - BHYT (1.5%%)                         :           %.2f VNĐ        |
                | - BHTN (1.0%%)                         :           %.2f VNĐ        |
                | - Đoàn phí Công đoàn (Cố định)        :           %.2f VNĐ        |
                | -> TỔNG KHẤU TRỪ                      :         %.2f VNĐ          |
                +-------------------------------------------------------------------+
                | III. THỰC NHẬN (NET PAY)                                          |
                | -> LƯƠNG THỰC NHẬN CUỐI CÙNG          :        %.2f VNĐ           |
                +-------------------------------------------------------------------+
                """,
                employeeID,
                employeeName,
                workingHours,
                hourlyWage,
                basicSalary,
                monthlyAllowance,
                grossSalary,
                socialInsurance,
                healthInsurance,
                unimploymentInsurance,
                unionFee,
                totalDeduction,
                netPay
        );

    }
}
