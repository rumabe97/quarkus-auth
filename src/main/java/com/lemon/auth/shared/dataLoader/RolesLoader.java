package com.lemon.auth.shared.dataLoader;

import com.lemon.auth.content.rol.application.port.in.RolPort;
import com.lemon.auth.content.rol.domain.Rol;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import jakarta.annotation.Priority;

@ApplicationScoped
public class RolesLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(RolesLoader.class.getName());
    @Inject
    RolPort rolPort;
    void onStart(@Observes @Priority(value = 1) StartupEvent ev) {
        LOGGER.info("On start - clean and load");
        Rol test = new Rol();
        test.setName("test");
        test.setDescription("test");
        test.setId(1L);
        rolPort.createRol(test);
    }
}
