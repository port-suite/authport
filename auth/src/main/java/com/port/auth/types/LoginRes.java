package com.port.auth.types;

public class LoginRes {
    private int responseCode;
    private String responseMessage;
    private String authToken;
    private String name;
    private String surname;

    public LoginRes(int code, String message, String token, String name, String surname) {
        this.responseCode = code;
        this.responseMessage = message;
        this.authToken = token;
        this.name = name;
        this.surname = surname;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String toJsonString() {
        String res = "{\n";
        res += "\t\"response_code\": " + this.getResponseCode() + ",\n";
        res += "\t\"response_message\": " + "\"" + this.getResponseMessage() + "\",\n";
        res += "\t\"name\": " + "\"" + this.getName() + "\",\n";
        res += "\t\"surname\": " + "\"" + this.getSurname() + "\",\n";
        res += "\t\"auth_token\": " + "\"" + this.getAuthToken() + "\"\n}";
        return res;
    }
}
