package vitals;

public class StateEstimator {
	
	final float MAX_TEMPERATURE = 45;
	final float MIN_TEMPERATURE = 0;
	final float MAX_SOC= 80;
	final float MIN_SOC= 20;
	final float MAX_CHARGE_RATE= 0.8f;
	
	float temperature;
	float stateofcharge;
	float chargeRate;
	
	String msg=null;
	
	public StateEstimator() {
		
	}
	public StateEstimator(float temperature, float soc, float chargeRate) {
		this.temperature = temperature;
		this.stateofcharge = soc;
		this.chargeRate = chargeRate;
	}
	public boolean isBatteryOk() {
		boolean status_of_temp=isTemperatureWithinRange(this.temperature);
		boolean status_of_soc=isSocWithinRange(this.stateofcharge);
		boolean status_of_charge=isChargeWithinRange(this.chargeRate);
		if((status_of_temp && status_of_soc) && status_of_charge) {
			displayMsg(UserDisplayMsg.All_PARAM_RANGE_OK +"!");
			return true;
		}
		return false;
	}
	
	
	private UserDisplayMsg isVitalParamStatus(float max_val, float vital_param) {
		 return (vital_param>max_val) ? (UserDisplayMsg) UserDisplayMsg.BRECH_HIGH :(UserDisplayMsg) UserDisplayMsg.BRECH_LOW; }
	
	
	private boolean isVitalParamWithinRange(float min_val, float max_val, float vital_param) { 
			 return (vital_param < min_val || vital_param > max_val); }
	 
	
	public boolean isTemperatureWithinRange(float temperature) {		
		if(isVitalParamWithinRange(MIN_TEMPERATURE,MAX_TEMPERATURE, temperature)){
		}	
		return true;
	}
	public boolean isSocWithinRange(float stateofcharge) {
		if(isVitalParamWithinRange(MIN_SOC,MAX_SOC, stateofcharge)){
			displayMsg(UserDisplayMsg.SOC_OUT_OF_RANGE+" " +isVitalParamStatus(MAX_SOC , stateofcharge));
			return false;
		}	
		return true;
	}
	public boolean isChargeWithinRange(float chargeRate) {
		if(isVitalParamStatus(MAX_CHARGE_RATE, chargeRate).equals("high"))
		{
			displayMsg(UserDisplayMsg.CR_OUT_OF_RANGE+" "+UserDisplayMsg.BRECH_HIGH);
            return false;
		}
		return true;
	}

	public void displayMsg(String msg) {
		System.out.println(msg);
	}
}
