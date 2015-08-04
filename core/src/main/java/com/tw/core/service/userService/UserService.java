package com.tw.core.service.userService;

import com.tw.core.bean.User;
import java.util.List;

/**
 * Created by marry on 7/15/15.
 */
public interface UserService{
    public void insertUser(User user);
    public void deleteUser(String id);
    public List<User> getUsers();
    public User getUserById(String id);
    public void updateUser(User user);
    public void changeUserState(String userId);
}
