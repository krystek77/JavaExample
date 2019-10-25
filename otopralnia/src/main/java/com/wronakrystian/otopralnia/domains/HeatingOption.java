package com.wronakrystian.otopralnia.domains;

public enum HeatingOption {
	BOILER_FED(null),
	BOILER_FED_AND_PREP_FOR_STEAM_HEATING(null),
	DIRECT_STEAM_HEATING("Steam valve included"),
	ELECTRIC(null),
	DUAL_HEATING("Electric and steam"),
	ELECTRIC_AND_PREP_FOR_STEAM_HEATING(null),
	GAS("Please specify type when ordering"),
	STEAM(null),
	HEAT_POMP(null),
	MID_ELECTRIC("18kW - 35#;30kW - 75#");
	
	private String note;

	private HeatingOption(String note) {
		this.setNote(note);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
