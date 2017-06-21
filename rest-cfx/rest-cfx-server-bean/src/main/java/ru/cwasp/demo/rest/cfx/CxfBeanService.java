package ru.cwasp.demo.rest.cfx;

import ru.cwasp.demo.rest.common.DemoBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class CxfBeanService {
    @GET
    @Path("cfx/bean/create")
    @Produces("application/json")
    public DemoBean create() {
        return new DemoBean();
    }

}