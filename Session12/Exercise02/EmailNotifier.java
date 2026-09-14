package Exercise02;

public class EmailNotifier implements INotifier {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[Email to " + recipient + "] Title: CRM Notice -> Body: " + message);
    }
}
