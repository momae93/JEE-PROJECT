package com.mti.converter.user;

import com.mti.converter.Converter;
import com.mti.entity.User;
import com.mti.presentation.usercontroller.GetAllResponse;

/**
 * Converter : User entity to User response
 */
public class UserEntityToResponseConverter implements Converter<User, GetAllResponse.UserResponse> {
    @Override
    public GetAllResponse.UserResponse convert(User from) {
        return new GetAllResponse.UserResponse(from.getId(), from.getUsername(), from.getPassword(), from.getIsActive());
    }
}
