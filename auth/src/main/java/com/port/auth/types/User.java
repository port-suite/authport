package com.port.auth.types;

public class User {
    private String email;
    private String password;
    private String name;
    private String surname;
    private int id;
    private String auth_token;
    private int logged_in_count;

    public User(String email, String password, String name, String surname, int id, String auth_token,
            int logged_in_count) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.auth_token = auth_token;
        this.logged_in_count = logged_in_count;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public String getAuthToken() {
        return auth_token;
    }

    public void setAuthToken(String newToken) {
        this.auth_token = newToken;
    }

    public int getLoggedInCount() {
        return logged_in_count;
    }

    public void incrementLoggedInCount() {
        this.logged_in_count++;
    }

    public void decrementLoggedInCount() {
        this.logged_in_count--;
    }
}
