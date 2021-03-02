package vitals;

public class BMS {
	static boolean batteryIsOk(float temperature, float soc, float chargeRate) {       
        StateEstimator state_estimator = new StateEstimator(temperature, soc, chargeRate);
        return state_estimator.isBatteryOk();
    }
	
    public static void main(String[] args) {
    	StateEstimator state_estimator = new StateEstimator();
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(30, 85, 0.0f) == false);
        assert(batteryIsOk(-1, -20, 0.7f)==false);
        assert(batteryIsOk(60, 90, 0.9f)==false);
        assert(state_estimator.isTemperatureWithinRange(25)==true);
        assert(state_estimator.isTemperatureWithinRange(50)==false);
        assert(state_estimator.isSocWithinRange(-20)==false);
        assert(state_estimator.isChargeWithinRange(0.9f)==false);
    }
}
