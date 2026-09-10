package Exercise03;

public class Main {
    public static void main(String[] args) {
        SmartSpeaker speaker = new SmartSpeaker("Rikkei Echo Dot");

        String trackName = "Sơn Tùng M-TP - Lạc Trôi";
        int durationSeconds = 60;

        System.out.printf("""
                --- THỬ NGHIỆM TÍNH NĂNG SMART SPEAKER ---

                +------------------------------------------------------------+
                |              NHẬT KÝ ĐIỀU KHIỂN LOA THÔNG MINH            |
                +------------------------------------------------------------+
                | Thiết bị: %s
                |------------------------------------------------------------|
                """,
                speaker.getDeviceName());

        speaker.playAudio(trackName);
        speaker.recordVoice(durationSeconds);

        System.out.println(
                "+------------------------------------------------------------+"
        );
    }
}
