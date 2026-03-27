package com.port.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Optional;
import java.util.UUID;

import com.port.auth.types.User;

public class Storage {
    private Connection connection;
    private Statement statement;

    public Storage() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:.db");
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public Optional<User> getUserWithEmail(String email) {
        try {
            String query = "SELECT * FROM user WHERE email = '%s'";
            ResultSet rs = this.statement.executeQuery(String.format(query, email));
            while (rs.next()) {
                User user = new User(rs.getString("email"), rs.getString("password"), rs.getString("name"),
                        rs.getString("surname"), rs.getInt("id"), rs.getString("auth_token"),
                        rs.getInt("logged_in_count"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            return Optional.empty();
        }
        return Optional.empty();
    }

    public boolean createNewUser(String email, String password, String name, String surname) {
        try {
            String query = "INSERT INTO user(email, password, name, surname, logged_in_count) values('%s', '%s', '%s', '%s', 0)";
            this.statement.executeUpdate(String.format(query, email, password, name, surname));
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    private boolean userLoggedIn(String userToken, String ipAddr) {
        try{
            String query = "SELECT * FROM auth_key WHERE user_token = '%s' AND ip_addr = '%s'";
            ResultSet rs = this.statement.executeQuery(String.format(query, userToken, ipAddr));
            while (rs.next()) {
                // TODO: DO THE THING
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public class LoginResult {
        public String authToken;
        public LoginStatus status;

        public LoginResult(String token, LoginStatus status) {
            this.authToken = token;
            this.status = status;
        }
    }

    public static enum LoginStatus {
        SUCCESS,
        FAILIURE,
        ALREADY_LOGGED_IN
    }

    public LoginResult loginUser(String email, String password, String clientIdentifier, String ipAddr) {
        String userToken;
        boolean firstTimeLogin = true;
        Optional<User> user = this.getUserWithEmail(email);
        if (user.isEmpty()) {
            return new LoginResult("", LoginStatus.FAILIURE);
        }
        if(user.get().getAuthToken() == null || user.get().getAuthToken().equals("")){
            System.out.println("generating new token");
            userToken = UUID.randomUUID().toString();
        } else {
            System.out.println("using existing token");
            firstTimeLogin = false;
            userToken = user.get().getAuthToken();
        }
        if (!firstTimeLogin && this.userLoggedIn(userToken, ipAddr)) {
            return new LoginResult("", LoginStatus.ALREADY_LOGGED_IN);
        }
        String clientUuid = UUID.randomUUID().toString();
        // TODO: return correct thing
        return new LoginResult("", LoginStatus.SUCCESS);
    }
}
