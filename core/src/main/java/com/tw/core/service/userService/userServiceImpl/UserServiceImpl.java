package com.tw.core.service.userService.userServiceImpl;

import com.tw.core.bean.User;
import com.tw.core.service.baseService.impl.BaseServiceImpl;
import com.tw.core.service.userService.UserService;

import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Override
    public void insertUser(User user){
        this.save(user);
    }
    @Override
    public void delelteUser(String id){
        this.deleteById(User.class,id);
    }
    @Override
    public List<User> getUsers(){
        List<User> users = this.queryAll(User.class);
        return users;
    }
    @Override
    public User getUserById(String id){
        User user = findById(User.class,id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        this.update(user);
    }
}
