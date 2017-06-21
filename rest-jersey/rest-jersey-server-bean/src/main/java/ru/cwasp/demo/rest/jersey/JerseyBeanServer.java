package ru.cwasp.demo.rest.jersey;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class JerseyBeanServer {
    private static final String BASE_URI = "http://localhost:8080/";

    private static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
                .packages("ru.cwasp.demo.rest.jersey")
                .register(JerseyJSONProvider.class);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.in.read();
        server.shutdownNow();
    }
}