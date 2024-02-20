package com.lemon.auth.shared.models;

import jakarta.ws.rs.core.Response;
import lombok.Getter;

@Getter
public enum ErrorEnum {
    EntityNotFoundException(Response.Status.NOT_FOUND),
    NotAllowedException(Response.Status.METHOD_NOT_ALLOWED),
    ConstraintViolationException(Response.Status.BAD_REQUEST),
    IllegalAccessException(Response.Status.INTERNAL_SERVER_ERROR),
    Default(Response.Status.INTERNAL_SERVER_ERROR);

    private final Response.Status status;

    ErrorEnum(Response.Status status) {
        this.status = status;
    }

    public static ErrorEnum getErrorData(String key) {
        for (ErrorEnum error : values()) {
            if (error.name().equalsIgnoreCase(key)) {
                return error;
            }
        }
        return ErrorEnum.Default;
    }

    public static Response mapExceptionToResponse(Exception exception) {
        String[] exceptionName = exception.getClass().getName().split("\\.");
        ErrorEnum error = ErrorEnum.getErrorData(exceptionName[exceptionName.length -1]);
        ErrorModel errorModel = new ErrorModel(error.getStatus().getReasonPhrase(),error.getStatus().getStatusCode(),exception.getMessage());
        return Response.status(errorModel.getCode()).entity(errorModel).build();
    }
}
