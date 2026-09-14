package Exercise05;

public class Main {
    public static void main(String[] args) {
        IAppraisable[] targets = {
                new Employee("Nguyễn Văn An", 85),
                new Employee("Trần Minh Đức", 75),
                new Branch("Chi nhánh Hà Nội", 12.5),
                new Branch("Chi nhánh Đà Nẵng", 8.5)
        };

        StringBuilder result = new StringBuilder();

        for (IAppraisable target : targets) {
            if (target instanceof Employee) {
                Employee employee = (Employee) target;

                result.append(String.format(
                        "| [Nhân viên] %-20s | Xếp hạng: %s%n",
                        employee.getEmpName(),
                        employee.getRating()
                ));
            } else if (target instanceof Branch) {
                Branch branch = (Branch) target;

                result.append(String.format(
                        "| [Chi nhánh] %-20s | Xếp hạng: %s%n",
                        branch.getBranchName(),
                        branch.getRating()
                ));
            }
        }

        System.out.printf("""
                --- ĐÁNH GIÁ XẾP HẠNG TỔ CHỨC ---

                +---------------------------------------------------------------+
                |             BÁO CÁO XẾP HẠNG CHẤT LƯỢNG RIKKEI              |
                +---------------------------------------------------------------+
                %s+---------------------------------------------------------------+
                """,
                result);
    }
}
