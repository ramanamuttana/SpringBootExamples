package org.chaptertwo.exampletwo.bookstore;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersistenceExceptionMapper implements ExceptionMapper<PersistenceException> {

	@Override
	public Response toResponse(PersistenceException exception) {
		if (exception instanceof EntityNotFoundException) {
			return Response.status(Status.NOT_FOUND).build();
		} else {

			Map<String, String> response = new HashMap<>();
			response.put("code", "ERR-4711");
			response.put("type", "DATABASE");
			response.put("message", exception.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(response).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}
}