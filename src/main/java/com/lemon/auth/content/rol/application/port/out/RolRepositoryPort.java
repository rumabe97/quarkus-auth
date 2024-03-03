package com.lemon.auth.content.rol.application.port.out;

import com.lemon.auth.content.rol.adapter.persistence.entity.RolEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RolRepositoryPort {

    RolEntity get(Long id);

    RolEntity getByName(String name);

    List<RolEntity> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    void createRol(RolEntity rol);
}
