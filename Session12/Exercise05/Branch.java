package Exercise05;

public class Branch implements IAppraisable {
    private String branchName;
    private double revenueBillion;

    public Branch(String branchName, double revenueBillion) {
        this.branchName = branchName;
        this.revenueBillion = revenueBillion;
    }

    @Override
    public String getRating() {
        if (revenueBillion >= 10) {
            return "Chi nhánh Hạng A";
        }
        return "Chi nhánh Hạng B";
    }

    public String getBranchName() {
        return branchName;
    }
}
