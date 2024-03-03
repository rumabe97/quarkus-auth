package com.lemon.auth.content.rol.application.port.in;

import com.lemon.auth.content.rol.domain.Rol;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RolPort {

    Rol get(Long id);

    Rol getByName(String name);

    List<Rol> getAll( String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    void createRol(Rol rol);
}
