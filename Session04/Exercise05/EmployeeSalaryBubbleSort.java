import java.util.Scanner;

public class EmployeeSalaryBubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- BẢNG XẾP HẠNG LƯƠNG NHÂN SỰ BUBBLE SORT ---");
        System.out.print("Nhập số kỹ sư (N): ");
        int n = Integer.parseInt(scanner.nextLine());

        double[] salaries = new double[n];

        for (int i = 0; i < salaries.length; i++) {
            System.out.print("Lương Kỹ sư #" + i + ": ");
            salaries[i] = Double.parseDouble(scanner.nextLine());
        }

        double[] originalSalaries = new double[n];
        System.arraycopy(salaries, 0, originalSalaries, 0, salaries.length);

        for (int i = 0; i < salaries.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < salaries.length - 1 - i; j++) {
                if (salaries[j] < salaries[j + 1]) {
                    double temp = salaries[j];
                    salaries[j] = salaries[j + 1];
                    salaries[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        String original = "";
        for (int i = 0; i < originalSalaries.length; i++) {
            original += originalSalaries[i];

            if (i < originalSalaries.length - 1) {
                original += ", ";
            }
        }

        String sorted = "";
        for (int i = 0; i < salaries.length; i++) {
            sorted += salaries[i];

            if (i < salaries.length - 1) {
                sorted += ", ";
            }
        }

        String top = "";
        for (int i = 0; i < 3 && i < salaries.length; i++) {
            top += String.format("| TOP %d Thu nhập:     %.2f Triệu VNĐ%n",
                    i + 1, salaries[i]);
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |            KẾT QUẢ SẮP XẾP LƯƠNG NHÂN SỰ            |
                +-------------------------------------------------------+
                | Lương ban đầu:      [%s]
                | Lương giảm dần:     [%s]
                |-------------------------------------------------------|
                %s+-------------------------------------------------------+
                """,
                original,
                sorted,
                top
        );

        scanner.close();
    }
}