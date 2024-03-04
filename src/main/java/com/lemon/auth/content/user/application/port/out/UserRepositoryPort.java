package com.lemon.auth.content.user.application.port.out;

import com.lemon.auth.content.user.adapter.persistence.entity.UserEntity;
import com.lemon.auth.content.user.domain.User;
import com.lemon.auth.shared.exception.ChangePasswordException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserRepositoryPort {

    UserEntity get(long id);

    List<UserEntity> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    List<UserEntity> search(UserEntity searchUser, String order, Integer quantity, Integer page) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

    UserEntity create(UserEntity user);

    UserEntity update(UserEntity user, long id);

    void delete(long id);

    UserEntity changePassword(String password, long id) throws ChangePasswordException;
}
