package com.mti.dao;


import com.mti.model.UserModel;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UserDao extends AbstractDao<UserModel> {
    /**
     * Constructor.
     */
    public UserDao() {
        super(UserModel.class);
    }
}
