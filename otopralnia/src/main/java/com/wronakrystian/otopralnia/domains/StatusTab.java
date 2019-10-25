package com.wronakrystian.otopralnia.domains;

public enum StatusTab {
	STANDARD("Standard version"),
	OPTION_NO_COSTS("Please specify when ordering"),
	OPTION_EXTRA_COSTS("Option for additional charge"),
	NOT_AVAILABLE("Option is not available for this type machine");
	
	private String note;
	
	private StatusTab(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
