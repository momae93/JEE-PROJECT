package com.mti.service;

import com.mti.converter.user.UserEntityToModelConverter;
import com.mti.converter.user.UserModelToEntityConverter;
import com.mti.dao.UserDao;
import com.mti.entity.User;
import com.mti.model.UserModel;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

public class UserService {
    @Inject
    private UserDao userDao;

    @Inject
    private UserModelToEntityConverter userModelToEntityConverter;

    @Inject
    private UserEntityToModelConverter userEntityToModelConverter;

    public List<User> findAll(){
        return userModelToEntityConverter.convert(userDao.findAll());
    }

    public User findById(final int id){
        final UserModel user = userDao.find(id);
        return (user == null) ? new User() : userModelToEntityConverter.convert(userDao.find(id));
    }

    @Transactional
    public User save(final User user){
        final UserModel model = userEntityToModelConverter.convert(user);
        final UserModel result = userDao.save(model);
        return userModelToEntityConverter.convert(result);
    }

    @Transactional
    public User disable(final User user){
        final UserModel model = userEntityToModelConverter.convert(user);
        model.setIsActive(false);
        final UserModel result = userDao.save(model);
        return userModelToEntityConverter.convert(result);
    }
}
