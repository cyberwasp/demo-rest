package ru.cwasp.demo.rest.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("simple")
public class ResteasySimpleService {
    @GET
    @Path("hello/{name}")
    public String hello(@PathParam("name") final String name) {
        return "Hello " + name;
    }
}