package ru.cwasp.demo.rest.jersey;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyClientProxied {

    private static final String PROXY_HOST = "localhost";
    private static final int PROXY_PORT = 808;
    private static final String PROXY_USER = "test";
    private static final String PROXY_PASS = "test";
    private static final String URI = "https://httpbin.org/get";

    public static void main(String[] args) throws Exception {
        ClientConfig config = new ClientConfig();
        config.connectorProvider(new ApacheConnectorProvider());
        config.property(ClientProperties.PROXY_URI, "http://" + PROXY_HOST + ":" + PROXY_PORT);
        config.property(ClientProperties.PROXY_USERNAME, PROXY_USER);
        config.property(ClientProperties.PROXY_PASSWORD, PROXY_PASS);
        JerseyClient client = new JerseyClientBuilder()
                .withConfig(config)
                .build();
        JerseyWebTarget target = client.target(URI);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        System.out.println(response.readEntity(String.class));
        response.close();
    }
}
