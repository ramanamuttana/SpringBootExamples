package org.chaptertwo.exampletwo.bookstore.client;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.chaptertwo.exampletwo.bookstore.Book;
import org.chaptertwo.exampletwo.bookstore.BookResource;
import org.glassfish.jersey.jsonb.JsonBindingFeature;

public class LibraryServiceClient {
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String[] args) {
        // construct a JAX-RS client using the builder
		Client client = ClientBuilder.newBuilder()
				.register(JsonBindingFeature.class).build();
        // construct a web target for the library service
		WebTarget api = client.target("http://localhost:8080").path("/library-service/api");
		
		// get each book through client 
		

	    LOGGER.log(Level.INFO, "Get list of books.");
	    List<Book> books =  api.path("/books").request()
			.accept(MediaType.APPLICATION_JSON).get(Book.class);
			books.forEach(book -> LOGGER.log(Level.INFO, "{0}", book));
}

	}
