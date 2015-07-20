package com.tw.core.service.userService.userServiceImpl;

import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.service.baseService.impl.BaseServiceImpl;
import com.tw.core.service.userService.UserLoginService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marry on 7/20/15.
 */
@Service
public class UserLoginServiceImpl extends BaseServiceImpl implements UserLoginService {
    @Override
    public User getUserByNameAndPassword(String username,String password) {
        DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
        dCriteria.add(Restrictions.eq("userName", username));
        dCriteria.add(Restrictions.eq("password", password));
        List<User> users = queryAllOfCondition(User.class, dCriteria);
        User user = users.get(0);
        return user;
    }
}
