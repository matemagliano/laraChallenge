package com.laraChallenge.message;

import java.util.Map;

public class ButtonSelectedWebhookBody {
	private Data data;
    private Map<String, String> context;
    
    public ButtonSelectedWebhookBody(Data data, Map<String, String> context) {
		this.setData(data);
		this.context = context;
	}
    	
	public Map<String, String> getContext() {
		return context;
	}
	public void setContext(Map<String, String> context) {
		this.context = context;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public static class Data {
        private String type;
        private String employeeId;
        private String value;

        public Data() {
        }

        public Data(String type, String employeeId, String value) {
            this.type = type;
            this.employeeId = employeeId;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    
}
