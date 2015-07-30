package com.tw.core;

import com.tw.core.bean.User;

/**
 * Created by marry on 7/20/15.
 */
public interface UserLoginService {
    public User getUserByNameAndPassword(String username,String password);
}
