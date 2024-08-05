package com.laraChallenge.message;

import java.util.Map;

public class TextWebhookBody {

    private Data data;
    private Map<String, String> headers;

    public TextWebhookBody() {
    }

    public TextWebhookBody(Data data, Map<String, String> headers) {
        this.data = data;
        this.headers = headers;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public static class Data {
        private String type;
        private String employeeId;
        private String text;

        public Data() {
        }

        public Data(String type, String employeeId, String text) {
            this.type = type;
            this.employeeId = employeeId;
            this.text = text;
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

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
