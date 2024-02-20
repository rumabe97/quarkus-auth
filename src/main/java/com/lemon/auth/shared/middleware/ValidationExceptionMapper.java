package com.lemon.auth.shared.middleware;

import com.lemon.auth.shared.models.ErrorEnum;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        return ErrorEnum.mapExceptionToResponse(exception);
    }
}