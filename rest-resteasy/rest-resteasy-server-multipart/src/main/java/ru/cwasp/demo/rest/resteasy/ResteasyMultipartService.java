package ru.cwasp.demo.rest.resteasy;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Path("multipart")
@Provider
public class ResteasyMultipartService {
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@MultipartForm ResteasyUploadForm form) {
        System.out.println("Uploaded file size = " + form.getData().length);
        return Response.status(200).entity("File uploaded with comment " + form.getComment()).build();
    }
}