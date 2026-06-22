package quarkus;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoSuchElementExceptionMapper implements ExceptionMapper<java.util.NoSuchElementException> {

    public static record NoSuchElementMessage(
            String message,
            String detail) {
    }

    @Override
    public Response toResponse(java.util.NoSuchElementException exception) {

        var error = new NoSuchElementMessage(
                exception.getMessage(),
                null);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}