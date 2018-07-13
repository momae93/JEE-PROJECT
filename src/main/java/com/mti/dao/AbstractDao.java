package com.mti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class AbstractDao<MODEL_TYPE> {
    /**
     * Model class.
     */
    protected final Class<MODEL_TYPE> modelClass;

    @PersistenceContext(unitName="jpaUnit")
    protected EntityManager entityManager;


    public AbstractDao(Class<MODEL_TYPE> modelClass) {
        this.modelClass = modelClass;
    }

    /**
     *
     * @param id
     * @return Model by Id.
     */
    public MODEL_TYPE find(final int id) {
        return entityManager.find(modelClass, id);
    }

    /**
     *
     * @param model
     * @return Model that was post.
     */
    public MODEL_TYPE save(final MODEL_TYPE model) {
        return entityManager.merge(model);
    }

    /**
     *
     * @return List of Models.
     */
    public List<MODEL_TYPE> findAll() {
        final TypedQuery<MODEL_TYPE> query = entityManager.createQuery("FROM " + modelClass.getSimpleName(), modelClass);
        return query.getResultList();
    }
}

