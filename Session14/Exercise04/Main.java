package Exercise04;

public class Main {
    public static void main(String[] args) {

        CandidateService service = new CandidateService();

        int[] ages = {25, 16, 65};

        System.out.println("--- KIỂM DUYỆT TUỔI ỨNG VIÊN RIKKEI CAREERS ---");

        for (int i = 0; i < ages.length; i++) {
            try {
                System.out.print("[UV " + (i + 1) + " - " + ages[i] + " tuổi]: ");
                service.validateAge(ages[i]);
            } catch (InvalidAgeException e) {
                System.out.println("[UV " + (i + 1) + " - " + ages[i] + " tuổi]: LỖI: " + e.getMessage());
            }
        }
    }
}
