package org.chaptertwo.exampletwo.bookstore.clientsideTest;

import org.chaptertwo.exampletwo.bookstore.client.VersionResource;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.jsonb.JsonBindingFeature;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.GenericConverter;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

public class VersionResourceTest extends JerseyClient {
	protected Application configure() {
		ResourceConfig config = new ResourceConfig(VersionResource.class);
	}

	protected void configureClient(ClientConfig config) {
		// for JSON-B marshalling
		config.register(JsonBindingFeature.class);
	}

	@Test
	public void v1() {
		Response response = target("/version/v1").request().get();
		assertThat(response.getStatus(), is(200));
		assertThat(response.readEntity(String.class), is("v1.0"));
	}

	private Object is(String string) {

		return null;
	}

	private Object is(int i) {

		return null;
	}

	@ClassRule
	public static GenericConverter container = new GenericContainer(
			new ImageFromDockerfile().withFileFromFile("Dockerfile", new File(basePath(), "Dockerfile"))
					.withFileFromFile("target/library-service.war", new File(basePath(), "target/library-service.war")))
			.waitingFor(
					Wait.forHttp("/library-service/api/application.wadl").withStartupTimeout(Duration.ofSeconds(90)))
			.withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(LibraryServiceContainerTest.class)))
			.withExposedPorts(8080).withExtraHost("localhost", "127.0.0.1");
}

@Before
public void setUp() {
client = ClientBuilder.newBuilder()
.connectTimeout(5, TimeUnit.SECONDS)
.readTimeout(5, TimeUnit.SECONDS)
.register(JsonBindingFeature.class)
.build();
String uri = String.format("http://%s:%s/library-service/api",
container.getContainerIpAddress(),
container.getMappedPort(8080));
api = client.target(uri);
}