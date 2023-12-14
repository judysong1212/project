package com.msfgwt.widget.client;


public class RadioBoolSelector extends RadioSelector<Boolean> {
	public RadioBoolSelector(){
		this.addStyleName("msfgwt-RadioBoolSelector");
		
		this.addValue(Boolean.TRUE, "Yes");
		this.addValue(Boolean.FALSE, "No");
	}
}
