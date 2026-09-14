package Exercise06;

public class SmartAirConditioner extends SmartDevice {
    public SmartAirConditioner(String deviceId, String name) {
        super(deviceId, name);
    }

    @Override
    public double getDailyPowerConsumptionKWh() {
        if (isOn()) {
            return 12.0;
        }
        return 0.0;
    }
}
