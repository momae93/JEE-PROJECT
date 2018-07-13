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
    /**
     * User Dao.
     */
    @Inject
    private UserDao userDao;

    /**
     * User Model to Entity Converter.
     */
    @Inject
    private UserModelToEntityConverter userModelToEntityConverter;

    /**
     * User Entity to Model Converter.
     */
    @Inject
    private UserEntityToModelConverter userEntityToModelConverter;

    /**
     *
     * @return List of User.
     */
    public List<User> findAll(){
        return userModelToEntityConverter.convert(userDao.findAll());
    }

    /**
     *
     * @param id
     * @return User by Id.
     */
    public User findById(final int id){
        final UserModel user = userDao.find(id);
        return (user == null) ? new User() : userModelToEntityConverter.convert(userDao.find(id));
    }

    /**
     *
     * @param user
     * @return Post of a user.
     */
    @Transactional
    public User save(final User user){
        final UserModel model = userEntityToModelConverter.convert(user);
        final UserModel result = userDao.save(model);
        return userModelToEntityConverter.convert(result);
    }

    /**
     *
     * @param user
     * @return User modified.
     */
    @Transactional
    public User disable(final User user){
        final UserModel model = userEntityToModelConverter.convert(user);
        model.setIsActive(false);
        final UserModel result = userDao.save(model);
        return userModelToEntityConverter.convert(result);
    }
}
