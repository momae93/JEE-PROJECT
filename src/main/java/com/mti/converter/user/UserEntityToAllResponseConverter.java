package com.mti.converter.user;

import com.mti.converter.Converter;
import com.mti.entity.User;
import com.mti.presentation.usercontroller.GetAllResponse;

public class UserEntityToAllResponseConverter implements Converter<User, GetAllResponse.UserResponse> {
    @Override
    public GetAllResponse.UserResponse convert(User from) {
        return new GetAllResponse.UserResponse(from.getId(), from.getUsername(), from.getPassword(), from.getIsActive());
    }
}
