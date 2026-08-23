import java.util.Scanner;

public class MultiBranchSalesRevenueAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("--- HỆ THỐNG TỔNG HỢP DOANH THU RIKKEI RETAIL ---\nNhập số lượng chi nhánh (N): ");
        int n = Integer.parseInt(scanner.nextLine());

        String[] branchNames = new String[n];
        double[][] revenues = new double[n][4];
        double[] totalYearRevenues = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Chi nhánh #" + i + " - Tên: ");
            String name = scanner.nextLine().trim().toLowerCase();

            StringBuilder normalizedName = new StringBuilder();
            boolean capitalize = true;

            for (int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);

                if (c == ' ') {
                    if (normalizedName.length() > 0 && normalizedName.charAt(normalizedName.length() - 1) != ' ') {
                        normalizedName.append(c);
                    }
                    capitalize = true;
                } else {
                    if (capitalize) {
                        normalizedName.append(Character.toUpperCase(c));
                        capitalize = false;
                    } else {
                        normalizedName.append(c);
                    }
                }
            }

            branchNames[i] = normalizedName.toString();

            for (int j = 0; j < 4; j++) {
                System.out.print("Q" + (j + 1) + ": ");
                revenues[i][j] = Double.parseDouble(scanner.nextLine());
                totalYearRevenues[i] += revenues[i][j];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (totalYearRevenues[j] < totalYearRevenues[j + 1]) {
                    double tempTotal = totalYearRevenues[j];
                    totalYearRevenues[j] = totalYearRevenues[j + 1];
                    totalYearRevenues[j + 1] = tempTotal;

                    String tempName = branchNames[j];
                    branchNames[j] = branchNames[j + 1];
                    branchNames[j + 1] = tempName;

                    double[] tempRevenue = revenues[j];
                    revenues[j] = revenues[j + 1];
                    revenues[j + 1] = tempRevenue;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("""
                +------------------------------------------------------------------------------------------+
                |                         BẢNG XẾP HẠNG DOANH THU CHI NHÁNH                               |
                +------------------------------------------------------------------------------------------+
                | Hạng | Tên Chi Nhánh         | Q1         | Q2         | Q3         | Q4         | Tổng        |
                |------+------------------------+------------+------------+------------+------------+-------------|
                """);

        for (int i = 0; i < n; i++) {
            result.append(String.format(
                    "| #%-3d | %-22s | %,10.1f | %,10.1f | %,10.1f | %,10.1f | %,11.1f |%n",
                    i + 1,
                    branchNames[i],
                    revenues[i][0],
                    revenues[i][1],
                    revenues[i][2],
                    revenues[i][3],
                    totalYearRevenues[i]
            ));
        }

        result.append("+------------------------------------------------------------------------------------------+");

        System.out.print(result);

        scanner.close();
    }
}