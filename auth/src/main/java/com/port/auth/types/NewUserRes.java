package com.port.auth.types;

public class NewUserRes {
    private int responseCode;
    private String responseMessage;

    public NewUserRes(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String toJsonString() {
        String res = "{\n";
        res += "\t\"response_code\": " + this.getResponseCode() + ",\n";
        res += "\t\"response_message\": " + "\"" + this.getResponseMessage() + "\"\n}";
        return res;
    }

}
