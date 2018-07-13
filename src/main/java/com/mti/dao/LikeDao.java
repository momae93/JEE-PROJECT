package com.mti.dao;

import com.mti.entity.Like;
import com.mti.model.LikeModel;

public class LikeDao extends AbstractDao<LikeModel> {
    public LikeDao() {
        super(LikeModel.class);
    }
}
