package com.lemon.auth.content.user.adapter.persistence.repository;

import com.lemon.auth.content.user.adapter.persistence.entity.UserEntity;
import com.lemon.auth.content.user.application.port.out.UserRepositoryPort;
import com.lemon.auth.content.user.domain.User;
import com.lemon.auth.shared.search.CriteriaSearch;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
public class UserRepository implements UserRepositoryPort {

    @Inject
    EntityManager entityManager;

    @Inject
    CriteriaSearch<UserEntity> criteriaSearch;

    @Override
    public UserEntity get(long id) {
        return entityManager.getReference(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        UserEntity empty = new UserEntity();
        TypedQuery<UserEntity> query = criteriaSearch.buildQuery(entityManager,empty, UserEntity.class, order,quantity,page);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> search(UserEntity searchUser, String order, Integer quantity, Integer page) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        TypedQuery<UserEntity> query = criteriaSearch.buildQuery(entityManager,searchUser, UserEntity.class, order, quantity, page);
        return query.getResultList();
    }

    @Override
    public UserEntity create(UserEntity user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public UserEntity update(UserEntity user, long id) {
        user.setId(id);
        entityManager.merge(user);
        entityManager.flush();
        return get(id);
    }

    @Override
    public void delete(long id) {
        UserEntity user = get(id);
        entityManager.remove(user);
    }

    @Override
    public UserEntity changePassword(String password, long id) {
        UserEntity user = get(id);
        user.setPassword(password);
        entityManager.merge(user);
        entityManager.flush();
        return user;
    }
}
