package Exercise04;

public class CandidateService {

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Tuổi ứng viên " + age + " không hợp lệ!");
        }

        System.out.println("-> Xác thực tuổi thành công: " + age + " tuổi.");
    }
}
