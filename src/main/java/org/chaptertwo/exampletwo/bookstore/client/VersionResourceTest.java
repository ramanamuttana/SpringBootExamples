package org.chaptertwo.exampletwo.bookstore.client;

import org.glassfish.jersey.client.JerseyClient;

import jakarta.ws.rs.core.Application;

public class VersionResourceTest extends JerseyClient {
	@Override
	protected Application configure() {
		ResourceConfig config = new ResourceConfig(VersionResource.class);
	}
}