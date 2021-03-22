package vitals;

import java.util.HashMap;
import java.util.Map;

public class CheckAndAlertBatteryFactors {
	
	final float MAX_TEMPERATURE = 45;
	final float MIN_TEMPERATURE = 0;
	final float MAX_SOC= 80;
	final float MIN_SOC= 20;
	final float MAX_CHARGE_RATE= 0.8f;
	static Map<String,String> factorDetails=new HashMap<String,String>();
	float temperature;
	float stateofcharge;
	float chargeRate;
	
	public CheckAndAlertBatteryFactors() {
		
	}
	
	public CheckAndAlertBatteryFactors(float temperature, float soc, float chargeRate) {
		this.temperature = temperature;
		this.stateofcharge = soc;
		this.chargeRate = chargeRate;
	}
	
	
	private boolean isVitalParamHigh(float max_val, float factorval,String vitalfactor) {
		
		 return factorval>max_val;
	}
	
	private boolean isVitalParamLow(float min_val, float factorval,String vitalfactor) { 
			
	     return factorval < min_val;
	}
	 
	
	public boolean isTemperatureWithinRange(float temperature) {		
		
		boolean isTempHigh=CheckandUpdateFactordetails(isVitalParamHigh(MAX_TEMPERATURE,temperature,"Temperature"),"Temperature","High,it exceeds its Maximum("+MAX_TEMPERATURE+")\n");
		boolean isTempLow=CheckandUpdateFactordetails(isVitalParamLow(MIN_TEMPERATURE,temperature,"Temperature"),"Temperature","Low,it exceeds its Minimum("+MIN_TEMPERATURE+")\n");
		return isTempHigh&&isTempLow;
	}
	
	public boolean isSocWithinRange(float stateofcharge) {
		boolean isSocHigh=CheckandUpdateFactordetails(isVitalParamHigh(MAX_SOC,stateofcharge,"State of Charge"),"State of Charge","High,it exceeds its Maximum("+MAX_SOC+")\n");
		boolean isSocLow=CheckandUpdateFactordetails(isVitalParamLow(MIN_SOC,temperature,"State of Charge"),"State of Charge","Low,it exceeds its Minimum("+MIN_SOC+")\n");
		return isSocHigh&&isSocLow;
	}
	
	public boolean isChargeWithinRange(float chargeRate) {
		boolean isChargeRateHigh=CheckandUpdateFactordetails(isVitalParamHigh(MAX_CHARGE_RATE,chargeRate,"chargeRate"),"Charge Rate","High,it exceeds its Maximum("+MAX_CHARGE_RATE+")\n");
		return isChargeRateHigh;
	}
	
	public void printAlertMessage(){
		if(!factorDetails.isEmpty()){
			System.out.println(factorDetails.toString());
			return;
		}
		System.out.println("All factors Ok!");
	}
	private boolean CheckandUpdateFactordetails(boolean status,	String factor, String factorstatusMsg) {
		if(status){
			 factorDetails.put(factor,factorstatusMsg);
			 return false;
		}
		return true;
	}
	
}
