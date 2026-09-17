package Exercise03;

public class ReportExporter {

    public void exportReport(boolean shouldFail) {

        ServerResource res = new ServerResource();

        try {
            res.open();
            res.writeData(shouldFail);
        } catch (RuntimeException e) {
            System.out.println("[Cảnh báo Lỗi] " + e.getMessage());
        } finally {
            res.close();
        }
    }
}
