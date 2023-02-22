package org.chaptertwo.exampletwo.bookstore;

import java.net.URI;
import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/books")
public class BookResource {

	@Inject
	private Bookshelf bookshelf;
	@Context
	private ResourceContext context;
	
	@GetMapping 
	@Produces(MediaType.APPLICATION_JSON)
	public Response books() {
		return Response.ok(bookshelf.findAll()).build();
	//	return Response.ok("Hello").build();
	}
	
	@GetMapping("{isbn}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response get(@PathVariable("isbn") String isbn) {
		Book book = bookshelf.findByISBN(isbn);
		return Response.ok(book).build();
	}

	@Path("{isbn}/loans")
	public Response loans(@PathParam("isbn") String isbn) {
		LoanResource loanResource = context.getResource(LoanResource.class);
		return Response.ok(loanResource).build();
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Book book) {
		if (bookshelf.exists(book.getISBN())) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		bookshelf.create(book);
		URI location = UriBuilder.fromResource(BookResource.class).path("/{isbn}")
				.resolveTemplate("isbn", book.getISBN()).build();
		return Response.created(location).build();
	}

	@PUT
	@Path("/{isbn}")
	public Response update(@PathParam("isbn") String isbn, Book book) {
		
		if (!Objects.equals(isbn, book.getISBN())) {
			 throw new WebApplicationException(
			"ISBN must match path parameter.",
			Response.Status.BAD_REQUEST);
			}
			// 	bookshelf.update(isbn, book);
			// 	return Response.ok().build();
		return null;	 
	}

	@DELETE
	@Path("/{isbn}")
	public Response delete(@PathParam("isbn") String isbn) {
		bookshelf.delete(isbn);
		return Response.ok().build();
	}

	@Path("/{isbn}/author")
	public AuthorResource author(@PathParam("isbn") String isbn) {
		Book book = bookshelf.findByISBN(isbn);
		return new AuthorResource(book);
	}
}
