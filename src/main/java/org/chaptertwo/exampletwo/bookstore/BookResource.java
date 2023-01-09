package org.chaptertwo.exampletwo.bookstore;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.context.annotation.RequestScope;

@Path("books")
@RequestScope
public class BookResource {
	
	
	@Inject
	private Bookshelf bookshelf;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response books() {
	return Response.ok(bookshelf.findAll()).build();
	}

}
