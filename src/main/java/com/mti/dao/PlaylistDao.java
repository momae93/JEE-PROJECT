package com.mti.dao;

import com.mti.model.PlaylistModel;

public class PlaylistDao extends AbstractDao<PlaylistModel> {
    public PlaylistDao() {
        super(PlaylistModel.class);
    }
}
