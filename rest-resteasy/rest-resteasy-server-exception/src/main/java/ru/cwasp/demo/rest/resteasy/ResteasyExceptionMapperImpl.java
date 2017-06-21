package ru.cwasp.demo.rest.resteasy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResteasyExceptionMapperImpl implements ExceptionMapper<ResteasyExampleException> {

    @Override
    public Response toResponse(ResteasyExampleException e) {
        return Response.status(404)
                .entity("Ops!!!")
                .build();
    }

}