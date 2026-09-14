package Exercise02;

public class SMSNotifier implements INotifier {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[SMS to " + recipient + "] Message: " + message);
    }
}
