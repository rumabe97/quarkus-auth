package com.lemon.auth.content.user.adapter.persistence.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


public class UserListener {
    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate(UserEntity user){
        if (user.getPassword() == null) return;
        if (user.getPassword().startsWith("$2a$10$")) return;
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
    }
}
