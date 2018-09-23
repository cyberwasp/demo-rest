package ru.cwasp.demo.rest.resteasy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("persist")
@Produces(APPLICATION_JSON)
@Stateless
public class ResteasyPersistService {

    @PersistenceContext(unitName = "demo")
    private EntityManager entityManager;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("create")
    public Response create(@BeanParam DBBean bean) {
        entityManager.persist(bean);
        String id = String.valueOf(bean.getId());
        return Response.created(
                uriInfo.getBaseUriBuilder()
                        .path(ResteasyPersistService.class)
                        .path("get")
                        .path(id)
                        .build()
        ).build();
    }

    @GET
    @Path("get/{id}")
    public Response get(@PathParam("id") long id) {
        DBBean dbBean = entityManager.find(DBBean.class, id);
        return Response.accepted(dbBean)
                .build();
    }

    @GET
    @Path("get")
    public Response get() {
        TypedQuery<DBBean> query = entityManager.createQuery("select d from DBBean d", DBBean.class);
        return Response.accepted(query.getResultList())
                .build();
    }
}