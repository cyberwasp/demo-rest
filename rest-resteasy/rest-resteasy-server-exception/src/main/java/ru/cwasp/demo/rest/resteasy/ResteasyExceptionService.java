package ru.cwasp.demo.rest.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("exception")
@Produces(MediaType.APPLICATION_JSON)
public class ResteasyExceptionService {
    @GET
    @Path("throw")
    public String throw_() {
        throw new ResteasyExampleException();
    }
}