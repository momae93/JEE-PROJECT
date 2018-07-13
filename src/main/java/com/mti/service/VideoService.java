package com.mti.service;

import com.mti.converter.VideoEntityToModelConverter;
import com.mti.converter.VideoModelToEntityConverter;
import com.mti.dao.VideoDao;
import com.mti.entity.Video;
import com.mti.model.VideoModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class VideoService {

    @Inject
    private VideoDao videoDao;

    @Inject
    private VideoEntityToModelConverter videoEntityToModelConverter;

    @Inject
    private VideoModelToEntityConverter videoModelToEntityConverter;

    public List<Video> findByUserId(final int id) {
        return videoModelToEntityConverter.convert(videoDao.findByUserId(id));
    }

    public Video findById(final int id) {
       final VideoModel video = videoDao.find(id);
       return (video == null) ? new Video() : videoModelToEntityConverter.convert(video);
    }

    public Video findByToken(final String token) {
        final VideoModel video = videoDao.findByToken(token);
        return (video == null) ? new Video() : videoModelToEntityConverter.convert(video);
    }

    @Transactional
    public Video save(final Video video) {
        final VideoModel model = videoEntityToModelConverter.convert(video);
        final VideoModel result = videoDao.save(model);
        return videoModelToEntityConverter.convert(result);
    }
}
