package ru.cwasp.demo.rest.resteasy;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.util.PortProvider;

import java.io.IOException;

public class ResteasyBeanServer {
    public static void main(String[] args) throws IOException {
        final UndertowJaxrsServer server = new UndertowJaxrsServer().start(
                Undertow.builder().addHttpListener(8080, "localhost")
        );
        server.deploy(ResteasyBeanApplication.class);
        System.in.read();
        server.stop();
    }
}
