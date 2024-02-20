package com.lemon.auth.content.user.application.service;

import com.lemon.auth.content.user.application.mapper.UserDomainMapper;
import com.lemon.auth.content.user.application.port.in.UserPort;
import com.lemon.auth.content.user.application.port.out.UserRepositoryPort;
import com.lemon.auth.content.user.domain.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
public class UserService implements UserPort {
    @Inject
    UserRepositoryPort userRepositoryPort;
    @Inject
    UserDomainMapper mapper;

    @Override
    @Transactional
    public User get(long id) {
        return mapper.toDomainModel(userRepositoryPort.get(id));
    }

    @Override
    @Transactional
    public List<User> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return userRepositoryPort.getAll(order, quantity, page).stream().map(userEntity -> mapper.toDomainModel(userEntity)).toList();
    }

    @Override
    public List<User> search(User searchUser, String order, Integer quantity, Integer page) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return userRepositoryPort.search(mapper.toEntity(searchUser), order,quantity,page).stream().map(userEntity -> mapper.toDomainModel(userEntity)).toList();
    }

    @Override
    @Transactional
    public User create(User user) {
        return mapper.toDomainModel(userRepositoryPort.create(mapper.toEntity(user)));
    }

    @Override
    @Transactional
    public User update(User user, long id) {
        return mapper.toDomainModel(userRepositoryPort.update(mapper.toEntity(user),id));
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepositoryPort.delete(id);
    }

    @Override
    @Transactional
    public User changePassword(String password, long id) {
        return mapper.toDomainModel(userRepositoryPort.changePassword(password, id));
    }
}
