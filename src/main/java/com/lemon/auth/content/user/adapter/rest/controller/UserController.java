package com.lemon.auth.content.user.adapter.rest.controller;

import com.lemon.auth.content.user.adapter.rest.dto.in.SearchUserInDto;
import com.lemon.auth.content.user.adapter.rest.dto.in.UpdateUserInDto;
import com.lemon.auth.content.user.adapter.rest.dto.in.UserInDto;
import com.lemon.auth.content.user.adapter.rest.dto.out.UserOutDto;
import com.lemon.auth.content.user.adapter.rest.mapper.UserDtoMapper;
import com.lemon.auth.content.user.application.port.in.UserPort;
import com.lemon.auth.shared.password.validator.ValidationQueryParam;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Tag(name="user")
@Path("api/user")
@ApplicationScoped
public class UserController {
    @Inject
    UserPort userPort;
    @Inject
    UserDtoMapper mapper;

    @GET
    @Path("{id}")
    @Operation(summary = "Get a User entity.")
    public UserOutDto get(@PathParam("id") Long id) {
        return mapper.toOutDto(userPort.get(id));
    }

    @GET
    @Path("/all")
    @Operation(summary = "Get all User entity.")
    public List<UserOutDto> getAll(
            @QueryParam("order") String order,
            @QueryParam("quantity") Integer quantity,
            @QueryParam("page") Integer page
    ) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return userPort.getAll(order, quantity, page).stream().map(user -> mapper.toOutDto(user)).toList();
    }

    @POST
    @Path("/search")
    @Operation(summary = "Search User entity.")
    public List<UserOutDto> search(
            @QueryParam("order") String order,
            @QueryParam("quantity") Integer quantity,
            @QueryParam("page") Integer page,
            SearchUserInDto searchUser) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return userPort.search(mapper.toDomainModel(searchUser), order, quantity, page).stream().map(user -> mapper.toOutDto(user)).toList();
    }

    @POST
    @Operation(summary = "Create a User entity.")
    public UserOutDto create(
            @RequestBody(description = "Template data object", required = true)
            @Valid UserInDto user) {
        return mapper.toOutDto(userPort.create(mapper.toDomainModel(user)));
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update a User entity.")
    public UserOutDto put(
            @PathParam("id") Long id,
            @RequestBody(description = "Template data object", required = true)
            UpdateUserInDto user) {
        return mapper.toOutDto(userPort.update(mapper.toDomainModel(user), id));
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a User entity.")
    public void delete(@PathParam("id") Long id) {
        userPort.delete(id);
    }

    @PATCH
    @Path("/changePassword/{id}")
    @Operation(summary = "Change Password")
    public UserOutDto changePassword(
            @PathParam("id") Long id,
            @QueryParam("password") @ValidationQueryParam String password
    ){
        return mapper.toOutDto(userPort.changePassword(password, id));
    }
}
