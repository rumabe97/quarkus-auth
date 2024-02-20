package com.lemon.auth.shared.middleware;

import com.lemon.auth.shared.models.ErrorEnum;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ErrorExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        return ErrorEnum.mapExceptionToResponse(exception);
    }
}

