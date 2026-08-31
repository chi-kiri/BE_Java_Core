package Exercise05;

public class Contact {
    public static final int PHONE_LENGTH = 10;

    private String contactId;
    private String contactName;
    private String phoneNumber;

    public Contact(String contactId, String contactName, String phone) {
        this.contactId = contactId;
        this.contactName = contactName;
        setPhoneNumber(phone);
    }

    public void setPhoneNumber(String phone) {
        if (phone.length() == PHONE_LENGTH && phone.startsWith("0")) {
            this.phoneNumber = phone;
        } else {
            System.out.println("[Cảnh báo SĐT] Số điện thoại '" + phone
                    + "' không đúng " + PHONE_LENGTH
                    + " số hoặc không bắt đầu bằng 0");
            this.phoneNumber = "0000000000";
        }
    }

    public void displayContact() {
        System.out.printf("| [%s] %-20s | SĐT: %s%n",
                contactId, contactName, phoneNumber);
    }
}
