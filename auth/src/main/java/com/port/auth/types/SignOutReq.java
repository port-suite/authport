package com.port.auth.types;

public class SignOutReq {
    private String email;
    private String client_identifier;
    private String ip_addr;
    
    public SignOutReq(String email, String client_identifier, String ip_addr) {
        this.email = email;
        this.client_identifier = client_identifier;
        this.ip_addr = ip_addr;
    }

    public String getEmail() {
        return this.email;
    }

    public String getClientIdentifier() {
        return this.client_identifier;
    }

    public String getIpAddr() {
        return this.ip_addr;
    }
}
