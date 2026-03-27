package com.port.auth.types;

public class LoginReq {
    private String email;
    private String password;
    private String client_identifier;
    private String remote_addr;

    public LoginReq(String email, String password, String client_identifier, String remote_addr) {
        this.email = email;
        this.password = password;
        this.client_identifier = client_identifier;
        this.remote_addr = remote_addr;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getClientIdentifier() {
        return this.client_identifier;
    }

    public String getRemoteAddr() {
        return this.remote_addr;
    }
}
