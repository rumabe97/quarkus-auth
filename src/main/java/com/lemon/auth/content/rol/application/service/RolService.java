package com.lemon.auth.content.rol.application.service;

import com.lemon.auth.content.rol.application.mapper.RolDomainMapper;
import com.lemon.auth.content.rol.application.port.in.RolPort;
import com.lemon.auth.content.rol.application.port.out.RolRepositoryPort;
import com.lemon.auth.content.rol.domain.Rol;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
public class RolService implements RolPort {
    @Inject
    RolRepositoryPort rolRepositoryPort;
    @Inject
    RolDomainMapper mapper;
    @Override
    @Transactional
    public Rol get(Long id) {
        return mapper.toDomainModel(rolRepositoryPort.get(id));
    }

    @Override
    @Transactional
    public Rol getByName(String name) {
        return mapper.toDomainModel(rolRepositoryPort.getByName(name));
    }

    @Override
    @Transactional
    public List<Rol> getAll(String order, Integer quantity, Integer page) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return rolRepositoryPort.getAll(order, quantity, page).stream().map(rolEntity -> mapper.toDomainModel(rolEntity)).toList();
    }
}
