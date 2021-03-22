package vitals;

public class BatteryManagementSystem {
	static boolean batteryIsOk(float temperature, float soc, float chargeRate) {       
		CheckAndAlertBatteryFactors factor_estimator = new CheckAndAlertBatteryFactors(temperature, soc, chargeRate);
       boolean isTempOk=factor_estimator.isTemperatureWithinRange(temperature);
       boolean isSocOk=factor_estimator.isSocWithinRange(soc);
       boolean ischargeRateok=factor_estimator.isChargeWithinRange(chargeRate);
       factor_estimator.printAlertMessage();
       return isTempOk&&isSocOk&&ischargeRateok;
    }
	
    public static void main(String[] args) {
    	
    	CheckAndAlertBatteryFactors factor_estimator = new CheckAndAlertBatteryFactors();
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(30, 85, 0.0f) == false);
        assert(batteryIsOk(-1, -20, 0.7f)==false);
        assert(batteryIsOk(60, 90, 0.9f)==false);
        assert(factor_estimator.isTemperatureWithinRange(25)==true);
        assert(factor_estimator.isChargeWithinRange(0.7f)==true);
        assert(factor_estimator.isSocWithinRange(-20)==false);
    }
}
