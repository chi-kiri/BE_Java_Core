package Exercise06;

public class Main {
    public static void main(String[] args) {
        SmartAirConditioner airConditioner =
                new SmartAirConditioner("AC-01", "Điều hòa Daikin");

        SmartLight light =
                new SmartLight("LT-01", "Đèn LED Philips");

        airConditioner.powerOn();
        light.powerOn();

        double totalConsumption =
                airConditioner.getDailyPowerConsumptionKWh()
                        + light.getDailyPowerConsumptionKWh();

        System.out.printf("""
                --- BẬT ĐIỀU HÒA VÀ ĐÈN THÔNG MINH ---

                +---------------------------------------------------------------+
                |              GIÁM SÁT NĂNG LƯỢNG TÒA NHÀ                     |
                +---------------------------------------------------------------+
                | [%s] %s | Trạng thái: %s | %.2f kWh
                | [%s] %s | Trạng thái: %s | %.2f kWh
                |---------------------------------------------------------------|
                | -> TỔNG ĐIỆN NĂNG TIÊU THỤ: %.2f kWh / ngày
                +---------------------------------------------------------------+
                """,
                airConditioner.getDeviceId(),
                airConditioner.getName(),
                airConditioner.isOn() ? "ON" : "OFF",
                airConditioner.getDailyPowerConsumptionKWh(),
                light.getDeviceId(),
                light.getName(),
                light.isOn() ? "ON" : "OFF",
                light.getDailyPowerConsumptionKWh(),
                totalConsumption);
    }
}
