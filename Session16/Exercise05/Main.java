package Exercise05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("NV1", "An", "IT"));
        employees.add(new Employee("NV2", "Bình", "HR"));
        employees.add(new Employee("NV3", "Cường", "IT"));
        employees.add(new Employee("NV4", "Dung", "SALES"));
        employees.add(new Employee("NV5", "Hùng", "HR"));

        String department = "IT";

        List<String> names =
                DepartmentService.getEmployeeNamesByDept(employees, department);

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|          DANH SÁCH NHÂN SỰ PHÒNG IT (STREAM MAP)     |");
        System.out.println("+-------------------------------------------------------+");

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("| %d. %-49s |\n", i + 1, names.get(i));
        }

        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| -> Tổng cộng: %d nhân sự phòng %-20s |\n",
                names.size(), department);
        System.out.println("+-------------------------------------------------------+");
    }
}