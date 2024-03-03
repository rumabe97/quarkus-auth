package com.lemon.auth.content.rol.adapter.persistence.repository;

import com.lemon.auth.content.rol.adapter.persistence.entity.RolEntity;
import com.lemon.auth.content.rol.application.port.out.RolRepositoryPort;
import com.lemon.auth.shared.search.CriteriaSearch;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
public class RolRepository implements RolRepositoryPort {
    @Inject
    EntityManager entityManager;

    @Inject
    CriteriaSearch<RolEntity> criteriaSearch;

    @Override
    public RolEntity get(Long id) {
        return entityManager.getReference(RolEntity.class, id);
    }

    @Override
    public RolEntity getByName(String name) {
        TypedQuery<RolEntity> query = entityManager.createQuery("SELECT r FROM RolEntity r WHERE r.name = :name", RolEntity.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    @Override
    public List<RolEntity> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        RolEntity empty = new RolEntity();
        TypedQuery<RolEntity> query = criteriaSearch.buildQuery(entityManager,empty, RolEntity.class, order,quantity,page);
        return query.getResultList();
    }
}
