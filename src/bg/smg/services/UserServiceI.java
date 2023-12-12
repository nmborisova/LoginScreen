package bg.smg.services;

import bg.smg.model.User;

public interface UserServiceI {
    public void saveUser(User user);
    public User getUser(int id);

}
