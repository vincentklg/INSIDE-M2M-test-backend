package org.acme.exceptionhandler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.exception.DeviceNotFoundException;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if(exception instanceof DeviceNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponseBody(exception.getMessage()))
                    .build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponseBody("Something unexpected happened. Try again"))
                .build();
    }

    public static final class ErrorResponseBody {

        private final String message;

        public ErrorResponseBody(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
