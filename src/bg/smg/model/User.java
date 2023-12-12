package bg.smg.model;

import java.util.Base64;

public class User {
    private String username;
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(username.getBytes());
        this.password = encodedPassword;
    }

}
