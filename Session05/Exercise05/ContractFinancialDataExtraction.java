import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContractFinancialDataExtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG TRÍCH XUẤT SỐ LIỆU HỢP ĐỒNG ---");
        System.out.print("Nhập nội dung hợp đồng: ");
        String contractText = scanner.nextLine();

        String regex = "\\b\\d{4,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contractText);

        StringBuilder moneyList = new StringBuilder();
        double totalContractValue = 0;
        int count = 0;

        while (matcher.find()) {
            double value = Double.parseDouble(matcher.group());
            totalContractValue += value;
            count++;

            if (moneyList.length() > 0) {
                moneyList.append(" | ");
            }

            moneyList.append(String.format("%,.0f", value));
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |           BÁO CÁO TRÍCH XUẤT SỐ LIỆU REGEX           |
                +-------------------------------------------------------+
                | Các số tiền tìm thấy: %s
                | Số khoản thanh toán:  %d khoản
                |-------------------------------------------------------|
                | TỔNG GIÁ TRỊ HỢP ĐỒNG: %,.2f VNĐ
                +-------------------------------------------------------+
                """, moneyList, count, totalContractValue);

        scanner.close();
    }
}