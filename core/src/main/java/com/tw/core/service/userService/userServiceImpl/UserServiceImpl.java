package com.tw.core.service.userService.userServiceImpl;

import com.tw.core.bean.User;
import com.tw.core.DAO.impl.BaseServiceImpl;
import com.tw.core.service.userService.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public void insertUser(User user){
        this.save(user);
    }

    @Override
    public void deleteUser(String id){
        this.deleteById(User.class, id);
    }

    @Override
    public List<User> getUsers(){
        List<User> users = this.queryAll(User.class);
        return users;
    }

    @Override
    public User getUserById(String id){
        User user = findById(User.class, id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        this.update(user);
    }

    @Override
    public void changeUserState(String userId){
        User user = getUserById(userId);
        user.setState("locked");
        updateUser(user);
    }
}
