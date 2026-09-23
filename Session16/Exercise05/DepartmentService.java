package Exercise05;

import java.util.List;

public class DepartmentService {
    public static List<String> getEmployeeNamesByDept(List<Employee> list, String dept) {
        return list.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(dept))
                .map(Employee::getName)
                .map(String::toUpperCase)
                .toList();
    }
}