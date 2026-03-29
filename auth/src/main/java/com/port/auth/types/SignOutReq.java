package com.port.auth.types;

public class SignOutReq {
    private String email;

    public SignOutReq(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
