package com.lemon.auth.shared.dataLoader.rol;

import com.lemon.auth.content.rol.application.port.in.RolPort;
import com.lemon.auth.content.rol.domain.Rol;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import jakarta.annotation.Priority;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class RolesLoader {
    @Inject
    RolPort rolPort;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");
    private static final String ROLVALUESLOCATION = "src/main/java/com/lemon/auth/shared/dataLoader/rol/Values.json";
    void onStart(@Observes @Priority(value = 1) StartupEvent ev) throws FileNotFoundException {
        Path directorioActual = Paths.get("").toAbsolutePath();
        LOGGER.info(directorioActual.toString());
        List<Rol> defaultValues = this.getDefaultValues();
        defaultValues.forEach(r -> rolPort.createRol(r));
    }

    private List<Rol> getDefaultValues() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader(ROLVALUESLOCATION));
        JsonArray jsonArray = reader.readArray();

        List<Rol> values = new ArrayList<>();

        jsonArray.forEach(jsonValue -> {
            Rol rol = new Rol();
            rol.setName(jsonValue.asJsonObject().getString("name"));
            rol.setDescription(jsonValue.asJsonObject().getString("description"));
            rol.setId((long) jsonValue.asJsonObject().getInt("id"));
            values.add(rol);
        });
        return values;
    }
}
