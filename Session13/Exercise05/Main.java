package Exercise05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("SV-02", "Nguyễn An", 3.8));
        list.add(new Student("SV-01", "Trần Bình", 3.8));
        list.add(new Student("SV-03", "Lê Cường", 3.2));
        list.add(new Student("SV-04", "Phạm Dũng", 3.5));

        Collections.sort(list, new GpaComparator());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);

            result.append(String.format(
                    "| Hạng %d | %-5s | %-15s | GPA: %.2f |%n",
                    i + 1,
                    student.getId(),
                    student.getName(),
                    student.getGpa()
            ));
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |          DANH SÁCH HỌC BỔNG (GPA GIẢM DẦN)           |
                +-------------------------------------------------------+
                %s+-------------------------------------------------------+
                """, result);
    }
}
