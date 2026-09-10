package Exercise03;

public class SmartSpeaker implements IPlayable, IRecordable {
    private String deviceName;

    public SmartSpeaker(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void playAudio(String trackName) {
        System.out.println("[Playable] Đang phát bài hát: " + trackName);
    }

    @Override
    public void recordVoice(int durationSeconds) {
        System.out.println("[Recordable] Đang ghi âm giọng nói trong: " + durationSeconds + " giây");
    }

    public String getDeviceName() {
        return deviceName;
    }
}
