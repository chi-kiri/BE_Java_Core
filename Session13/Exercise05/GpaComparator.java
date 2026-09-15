package Exercise05;
import java.util.Comparator;

public class GpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int result = Double.compare(s2.getGpa(), s1.getGpa());

        if (result != 0) {
            return result;
        }

        return s1.getId().compareTo(s2.getId());
    }
}