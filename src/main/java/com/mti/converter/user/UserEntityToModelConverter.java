package com.mti.converter.user;

import com.mti.converter.Converter;
import com.mti.entity.User;
import com.mti.model.UserModel;

/**
 * Converter : User entity to User model
 */
public class UserEntityToModelConverter implements Converter<User, UserModel> {
    @Override
    public UserModel convert(User from) {
        return new UserModel(from.getId(), from.getUsername(), from.getPassword(), from.getIsActive(), null);
    }
}
