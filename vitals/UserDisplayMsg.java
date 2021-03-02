package vitals;

public enum UserDisplayMsg {
	
	TEMP_OUT_OF_RANGE("Temperature is out of range! "),
	SOC_OUT_OF_RANGE("State of Charge is out of range! "),
	CR_OUT_OF_RANGE("Charge Rate is out of range! "),
	All_PARAM_RANGE_OK("All vital parameters are within defined range!"),
	BRECH_HIGH("--> Value high"),
	BRECH_LOW("--> Value low");
	
	private String displayText;
	
	private UserDisplayMsg(String displayText) {
		this.displayText = displayText;
	}
	
	public String toString() {
		return this.displayText;
	}
}
