package com.mti.converter.user;

import com.mti.converter.Converter;
import com.mti.entity.User;
import com.mti.model.UserModel;

public class UserModelToEntityConverter implements Converter<UserModel, User> {
    @Override
    public User convert(UserModel from) {
        return new User(from.getId(), from.getUsername(), from.getPassword(), from.getIsActive());
    }
}
