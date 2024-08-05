package com.laraChallenge.message;

public class Button {
	private String label;
	private String value;
	
    public Button(String label, String value) {
		this.label = label;
		this.value = value;
	}
    
	public Button() {
		// TODO Auto-generated constructor stub
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
