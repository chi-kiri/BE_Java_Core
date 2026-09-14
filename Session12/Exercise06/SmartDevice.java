package Exercise06;

public abstract class SmartDevice implements IRemoteControl, IEnergyMonitor {
    private String deviceId;
    private String name;
    private boolean isOn = false;

    public SmartDevice(String deviceId, String name) {
        this.deviceId = deviceId;
        this.name = name;
    }

    @Override
    public void powerOn() {
        isOn = true;
    }

    @Override
    public void powerOff() {
        isOn = false;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }
}
