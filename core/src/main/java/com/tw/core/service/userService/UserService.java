package com.tw.core.service.userService;

import com.tw.core.bean.User;
import com.tw.core.service.baseService.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marry on 7/15/15.
 */
public interface UserService extends BaseService {
    public void insertUser(User user);
    public void delelteUser(String id);
    public List<User> getUsers();
    public User getUserById(String id);
    public void updateUser(User user);
    public void changeUserState(String userId);
}
