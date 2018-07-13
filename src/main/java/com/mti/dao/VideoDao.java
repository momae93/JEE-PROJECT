package com.mti.dao;

import com.mti.model.VideoModel;

import javax.persistence.TypedQuery;
import java.util.List;


public class VideoDao extends AbstractDao<VideoModel> {
    /**
     * Constructor.
     */
    public VideoDao() {
        super(VideoModel.class);
    }

    /**
     *
     * @param id
     * @return List of Video by User id.
     */
    public List<VideoModel> findByUserId(final int id) {
        final TypedQuery<VideoModel> query = entityManager.createQuery("FROM VideoModel v WHERE v.id_user = :id_user", VideoModel.class);
        query.setParameter("id_user", id);
        return query.getResultList();
    }

    public VideoModel findByToken(final String token) {
        final TypedQuery<VideoModel> query = entityManager.createQuery("FROM VideoModel v WHERE v.token = :token", VideoModel.class);
        query.setParameter("token", token);
        return query.getSingleResult();
    }
}
