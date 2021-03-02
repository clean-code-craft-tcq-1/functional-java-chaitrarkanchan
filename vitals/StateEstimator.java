package vitals;

public class Battery {
	float temperature;
	float soc;
	float chargeRate;

	public Battery(float temperature, float soc, float chargeRate) {
		this.temperature = temperature;
		this.soc = soc;
		this.chargeRate = chargeRate;
	}
	public boolean isBatteryOk() {
		return (isTemperatureOk() && isSocOk()) && isChargeRateOk();
	}
	public boolean isTemperatureOk() {		
		if(!isFactorOk(Constants.TEMPERATURE_MIN_THRESHOLD, Constants.TEMPERATURE_MAX_THRESHOLD, temperature))
		{
			System.out.println("Temperature is out of range and is " + isFactorHigh(Constants.TEMPERATURE_MAX_THRESHOLD , temperature) + "!");
			return false;
		}	
		return true;
	}
	public boolean isSocOk() {
		if(!isFactorOk(Constants.SOC_MIN_THRESHOLD, Constants.SOC_MAX_THRESHOLD, soc))
		{
			System.out.println("State of charge is out of range and is " + isFactorHigh(Constants.SOC_MAX_THRESHOLD , soc) + "!");
			return false;
		}	
		return true;
	}
	public boolean isChargeRateOk() {
		if(isFactorHigh(Constants.CHARGE_RATE_MAX_THRESHOLD, chargeRate).equals("high"))
		{
			System.out.println("Charge Rate is out of range!");
            return false;
		}
		return true;
	}
	private String isFactorHigh(float max, float factor) {
		return (factor>max) ? "high" : "low"; 
	}
	private boolean isFactorOk(float min, float max, float value) {
		return !(value < min || value > max); 
	}
}
