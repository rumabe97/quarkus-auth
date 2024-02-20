package com.lemon.auth.shared.search;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CriteriaSearch<T> {
    public CriteriaSearch() {}
    public TypedQuery<T> buildQuery(EntityManager entityManager, T searchObject, Class<T> entityClass, String order, Integer quantity, Integer page) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        createQuery(criteriaBuilder, query, entityClass, searchObject, root);
        return queryOrdenation(query, criteriaBuilder, root, entityManager, order, page, quantity);
    }

    private void createQuery(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> query, Class<T> entityClass, T searchObject, Root<T> root ) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Predicate predicate = criteriaBuilder.conjunction();
        for (Field field : entityClass.getDeclaredFields()) {
            if (field.getName().contains("hibernate_")) continue;
            String getterMethodName = "get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
            Method getterMethod = entityClass.getMethod(getterMethodName);
            getterMethod.setAccessible(true);
            Object value = getterMethod.invoke(searchObject);
            if (value == null) continue;
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(field.getName()), value));
        }

        query.where(predicate);
    }

    private TypedQuery<T> queryOrdenation(CriteriaQuery<T> query, CriteriaBuilder criteriaBuilder, Root<T> root, EntityManager entityManager,String order, Integer page, Integer quantity){
        query.orderBy(criteriaBuilder.asc(root.get(order)));
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((page) * quantity);
        typedQuery.setMaxResults(quantity);
        return typedQuery;
    }
}
