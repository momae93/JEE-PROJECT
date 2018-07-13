package com.mti.dao;

import com.mti.entity.Video;
import com.mti.model.VideoModel;

import javax.persistence.TypedQuery;
import java.util.List;


public class VideoDao extends AbstractDao<VideoModel> {
    public VideoDao() {
        super(VideoModel.class);
    }


    public List<VideoModel> findByUserId(final int id) {
        final TypedQuery<VideoModel> query = entityManager.createQuery("FROM VideoModel v WHERE v.id_user = :id_user", VideoModel.class);
        query.setParameter("id_user", id);
        return query.getResultList();
    }
}
