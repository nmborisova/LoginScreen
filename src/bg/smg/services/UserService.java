package bg.smg.services;

import bg.smg.model.User;

import java.util.Base64;

public class UserService implements UserServiceI {

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    public boolean checkPassword(String pswd) {

        return true;
    }

    public String decodePassword(String passwordToDecode){
        byte[] decodedBytes = Base64.getDecoder().decode(passwordToDecode);
        return new String(decodedBytes);
    }
}
