package Exercise02;
import java.util.ArrayList;

public class SubjectManager<T extends Subject> {
    private ArrayList<T> subjects = new ArrayList<>();

    public void addSubject(T subject) {
        subjects.add(subject);
        System.out.println("Thêm môn học thành công!");
    }

    public void removeSubject(String code) {
        T foundSubject = null;

        for (T subject : subjects) {
            if (subject.getCode().equalsIgnoreCase(code)) {
                foundSubject = subject;
                break;
            }
        }

        if (foundSubject != null) {
            subjects.remove(foundSubject);
            System.out.println("Xóa môn học thành công!");
        } else {
            System.out.println("Không tìm thấy môn học có mã: " + code);
        }
    }

    public void displaySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học trống!");
            return;
        }

        System.out.println("Danh sách môn học:");

        for (T subject : subjects) {
            System.out.println(subject);
        }
    }

    public void searchByName(String name) {
        boolean found = false;

        for (T subject : subjects) {
            if (subject.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(subject);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có môn học phù hợp");
        }
    }

    public void filterByCredits() {
        boolean found = false;

        System.out.println("Các môn học có số tín chỉ > 3:");

        for (T subject : subjects) {
            if (subject.getCredits() > 3) {
                System.out.println(subject);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có môn học phù hợp");
        }
    }
}
