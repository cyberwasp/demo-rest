package ru.cwasp.demo.rest.resteasy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;

public class ResteasyClientSimple {

    public static void main(String[] args) throws Exception {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/resteasy/simple");
        Response response = target.request().get();
        System.out.println(response.readEntity(String.class));
        response.close();
    }
}
