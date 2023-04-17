package org.chaptertwo.exampletwo.bookstore.client;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.chaptertwo.exampletwo.bookstore.Book;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class LibraryServiceClient {
	
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String[] args) {
        // construct a JAX-RS client using the builder
		Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        // construct a web target for the library service
		WebTarget api = client.target("http://localhost:8080").path("/library-service/api");
		
		// get each book through client 
		

	    LOGGER.log(Level.INFO, "Get list of books.");
	    List<Book> books =  api.path("/books").request()
			.accept(MediaType.APPLICATION_JSON).get(bookList());
			books.forEach(book -> LOGGER.log(Level.INFO, "{0}", book));
			
	}
			private static GenericType<List<Book>> bookList() {
				return new GenericType<List<Book>>() {
				};
	}
	}
