package com.lemon.auth.content.user.application.port.in;

import com.lemon.auth.content.user.domain.User;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserPort {

    User get(long id);

    List<User> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;
    List<User> search(User searchUser, String order, Integer quantity, Integer page) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;

    User create(User user);

    User update(User  user, long id);

    void delete(long id);

    User changePassword(String password, long id);

}
