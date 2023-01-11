package org.chaptertwo.exampletwo.bookstore.client;


import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.jsonb.JsonBindingFeature;

public class LibraryServiceClient {
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String[] args) {
// construct a JAX-RS client using the builder
		Client client = ClientBuilder.newBuilder()
				.register(JsonBindingFeature.class).build();
// construct a web target for the library service
		WebTarget api = client.target("http://localhost:8080").path("/library-service/api");

	}
}
