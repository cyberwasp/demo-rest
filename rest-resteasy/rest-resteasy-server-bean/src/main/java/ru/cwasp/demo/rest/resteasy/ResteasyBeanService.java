package ru.cwasp.demo.rest.resteasy;

import ru.cwasp.demo.rest.common.DemoBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("bean")
public class ResteasyBeanService {
    @GET
    @Path("create")
    @Produces("application/json")
    public DemoBean create() {
        return new DemoBean();
    }

}