package ru.cwasp.demo.rest.resteasy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import ru.cwasp.demo.rest.common.DemoBean;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class ResteasyClientXML {

    public static void main(String[] args) throws Exception {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/resteasy/xml");
        Entity<DemoBean> e = Entity.xml(new DemoBean());
        Response response = target.request().post(e);
        System.out.println(response.readEntity(String.class));
        response.close();
    }
}
