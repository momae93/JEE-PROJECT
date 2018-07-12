package com.mti.dao;

import com.mti.model.VideoModel;

public class VideoDao extends AbstractDao<VideoModel> {
    public VideoDao() {
        super(VideoModel.class);
    }
}
