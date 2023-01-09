package org.chaptertwo.exampletwo.bookstore;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

	private final Book book;

	AuthorResource(Book book) {
		this.book = book;
	}

	@GET
	public Author get() {
		return book.getAuthor();
	}
}
