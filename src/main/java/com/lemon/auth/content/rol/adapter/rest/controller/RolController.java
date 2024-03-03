package com.lemon.auth.content.rol.adapter.rest.controller;

import com.lemon.auth.content.rol.adapter.rest.dto.out.RolOutDto;
import com.lemon.auth.content.rol.adapter.rest.mapper.RolDtoMapper;
import com.lemon.auth.content.rol.application.port.in.RolPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@ApplicationScoped
@Tag(name="rol")
@Path("api/rol")
public class RolController {
    @Inject
    RolPort rolPort;

    @Inject
    RolDtoMapper mapper;

    @GET
    @Path("{id}")
    @Operation(summary = "Get a Rol entity.")
    public RolOutDto get(@PathParam("id") Long id) {
        return mapper.toOutDto(rolPort.get(id));
    }

    @GET
    @Path("/getByName/{name}")
    @Operation(summary = "Get a Rol entity by name.")
    public RolOutDto getByName(@PathParam("name") String name) {
        return mapper.toOutDto(rolPort.getByName(name));
    }

    @GET
    @Path("/all")
    @Operation(summary = "Get all Rol entity.")
    public List<RolOutDto> getAll(
            @QueryParam("order") @DefaultValue("id") String order,
            @QueryParam("quantity") @DefaultValue("5") Integer quantity,
            @QueryParam("page") @DefaultValue("0")Integer page
    ) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return rolPort.getAll(order, quantity, page).stream().map(user -> mapper.toOutDto(user)).toList();
    }
}
