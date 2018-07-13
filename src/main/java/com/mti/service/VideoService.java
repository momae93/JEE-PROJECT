package com.mti.service;

import com.mti.converter.VideoModelToEntityConverter;
import com.mti.dao.VideoDao;
import com.mti.entity.Video;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VideoService {

    @Inject
    private VideoDao videoDao;

    @Inject
    private VideoModelToEntityConverter videoModelToEntityConverter;


    public List<Video> findByUserId(final int id) {
        return videoModelToEntityConverter.convert(videoDao.findByUserId(id));
    }

}
