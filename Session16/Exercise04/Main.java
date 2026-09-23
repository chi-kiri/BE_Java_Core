package Exercise04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("SV01", "An", 3.8));
        students.add(new Student("SV02", "Bình", 2.5));
        students.add(new Student("SV03", "Cường", 3.5));
        students.add(new Student("SV04", "Dung", 3.2));
        students.add(new Student("SV05", "Hoa", 2.9));
        students.add(new Student("SV06", "Hùng", 3.9));

        List<Student> honorStudents =
                StudentStreamService.getHonorStudents(students);

        StringBuilder result = new StringBuilder();

        result.append("+-------------------------------------------------------+\n");
        result.append("|             DANH SÁCH KHEN THƯỞNG (GPA >= 3.2)       |\n");
        result.append("+-------------------------------------------------------+\n");

        for (int i = 0; i < honorStudents.size(); i++) {
            Student student = honorStudents.get(i);

            result.append(String.format(
                    "| Hạng %d | %s | %-15s | GPA: %.2f |\n",
                    i + 1,
                    student.getId(),
                    student.getName(),
                    student.getGpa()
            ));
        }

        result.append("+-------------------------------------------------------+");

        System.out.print(result);
    }
}