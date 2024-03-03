package com.lemon.auth.content.user.adapter.persistence.entity;

import com.lemon.auth.content.rol.adapter.persistence.entity.RolEntity;
import com.lemon.auth.shared.password.CustomPasswordProvider;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.PasswordType;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.*;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import io.quarkus.elytron.security.common.BcryptUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(UserListener.class)
@Table(name = "users")
@UserDefinition
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "countryCode")
    private Integer countryCode;

    @Column(name = "password", nullable = false)
    @Password(value = PasswordType.CUSTOM, provider = CustomPasswordProvider.class)
    private String password;

    @Column(name = "userName", nullable = false)
    @Username
    private String userName;

    @Roles
    @ManyToMany
    @Column(name = "roles")
    public List<RolEntity> roles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userId")
    @OrderColumn
    private List<PasswordHistoryEntity> passwordHistory = new ArrayList<>(5);

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void addPasswordHistory(String newPassword) {
        List<PasswordHistoryEntity> history = this.getPasswordHistory();
        boolean isOld = history.stream().anyMatch(p -> BcryptUtil.matches(newPassword, p.getPassword()));
        if(isOld) throw new ConstraintViolationException("The new password has been used before. Please choose a different one", null);
        if(history.size() == 5) history.remove(0);
        PasswordHistoryEntity passwordHistoryItem = new PasswordHistoryEntity();
        passwordHistoryItem.setPassword(this.getPassword());
        passwordHistoryItem.setUser(this);
        history.add(passwordHistoryItem);
    }
}
