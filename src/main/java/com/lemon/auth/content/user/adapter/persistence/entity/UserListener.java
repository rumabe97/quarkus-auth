package com.lemon.auth.content.user.adapter.persistence.entity;

import com.lemon.auth.content.rol.adapter.persistence.entity.RolEntity;
import com.lemon.auth.content.rol.application.port.out.RolRepositoryPort;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserListener {
    @Inject
    RolRepositoryPort rolRepository;

    @PreUpdate
    public void prePersistOrUpdate(UserEntity user){
        this.passwordEncrypt(user);
    }

    @PrePersist
    public void prePersist(UserEntity user) {
        this.passwordEncrypt(user);
        this.setDefaultRol(user);
    }

    private void passwordEncrypt(UserEntity user){
        if (user.getPassword() == null) return;
        if (user.getPassword().startsWith("$2a$10$")) return;
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
    }

    private void setDefaultRol(UserEntity user){
        RolEntity rol = rolRepository.getByName("ROL_USER");
        List<RolEntity> defaultRoles = new ArrayList<>();
        defaultRoles.add(rol);
        user.setRoles(defaultRoles);
    }
}
