package com.port.auth.types;

public class NewUserReq {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String client_identifier;

    public NewUserReq(String email, String password, String name, String surname, String client_identifier) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.client_identifier = client_identifier;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getClientIdentifier() {
        return this.client_identifier;
    }

}
