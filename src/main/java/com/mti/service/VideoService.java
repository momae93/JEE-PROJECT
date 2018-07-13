package com.mti.service;

import com.mti.converter.video.VideoEntityToModelConverter;
import com.mti.converter.video.VideoModelToEntityConverter;
import com.mti.dao.VideoDao;
import com.mti.entity.Video;
import com.mti.model.VideoModel;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class VideoService {

    /**
     * Video Dao.
     */
    @Inject
    private VideoDao videoDao;

    /**
     * Video Entity To Model Converter.
     */
    @Inject
    private VideoEntityToModelConverter videoEntityToModelConverter;

    /**
     * Video Model To Entity Converter.
     */
    @Inject
    private VideoModelToEntityConverter videoModelToEntityConverter;

    /**
     *
     * @param id
     * @return List of videos by User id.
     */
    public List<Video> findByUserId(final int id) {
        return videoModelToEntityConverter.convert(videoDao.findByUserId(id));
    }

    /**
     *
     * @param id
     * @return Video by Id.
     */
    public Video findById(final int id) {
       final VideoModel video = videoDao.find(id);
       return (video == null) ? new Video() : videoModelToEntityConverter.convert(video);
    }

    public Video findByToken(final String token) {
        final VideoModel video = videoDao.findByToken(token);
        return (video == null) ? new Video() : videoModelToEntityConverter.convert(video);
    }

    /**
     *
     * @param video
     * @return Post of a video.
     */
    @Transactional
    public Video save(final Video video) {
        final VideoModel model = videoEntityToModelConverter.convert(video);
        final VideoModel result = videoDao.save(model);
        return videoModelToEntityConverter.convert(result);
    }
}
