package com.port.auth.types;

public class ValidateRes {
    private String name;
    private String surname;
    private String email;

    public ValidateRes(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }

    public String toJsonString() {
        String res = "{\n";
        res += "\t\"name\": " + "\"" + this.getName() + "\",\n";
        res += "\t\"surname\": " + "\"" + this.getSurname() + "\",\n";
        res += "\t\"email\": " + "\"" + this.getEmail() + "\"\n}";
        return res;
    }

}
