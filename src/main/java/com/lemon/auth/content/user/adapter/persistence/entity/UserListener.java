package com.lemon.auth.content.user.adapter.persistence.entity;

import com.lemon.auth.shared.password.PasswordValidator;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


public class UserListener {
    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate(UserEntity user){
        if (user.getPassword() == null) return;
        PasswordValidator.validatePassword(user.getPassword());
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
    }
}
