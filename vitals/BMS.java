package vitals;

public class BMS {
	static boolean batteryIsOk(float temperature, float soc, float chargeRate) {       
        Battery battery = new Battery(temperature, soc, chargeRate);
        return battery.isBatteryOk();
    }
    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        assert(batteryIsOk(45, 80, 0.8f) == true);
        assert(batteryIsOk(50 , 90, 0.9f) == false);
        assert(batteryIsOk(-1 , 40, 0.6f) == false);
        assert(batteryIsOk(25 , 15, 0.9f) == false);
        assert(batteryIsOk(25 , 65, 0.9f) == false);
        assert(batteryIsOk(50, 65, 0.7f) == false);
        assert(batteryIsOk(15, 85, 0.7f) == false);
        assert(batteryIsOk(15, 15, 0.7f) == false);
        assert(batteryIsOk(15, 25, 0.9f) == false);
    }
}
