package Exercise06;

public class SmartLight extends SmartDevice {
    public SmartLight(String deviceId, String name) {
        super(deviceId, name);
    }

    @Override
    public double getDailyPowerConsumptionKWh() {
        if (isOn()) {
            return 0.5;
        }
        return 0.0;
    }
}
