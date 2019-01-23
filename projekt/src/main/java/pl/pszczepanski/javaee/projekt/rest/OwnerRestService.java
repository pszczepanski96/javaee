package pl.pszczepanski.javaee.projekt.rest;

import pl.pszczepanski.javaee.projekt.domain.Owner;
import pl.pszczepanski.javaee.projekt.service.OwnerService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("owner")
public class OwnerRestService {

    @EJB
    OwnerService ownerService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Owner> getAllOwner(){
        return ownerService.getAllOwner();
    }

    @GET
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner getOwner(@PathParam("ownerId") int id) {
        return ownerService.getOwner(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOwner(Owner owner) {
        ownerService.addOwner(owner);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{ownerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducer(@PathParam("ownerId") int id, Owner transientOwner) {
        Owner owner = ownerService.getOwner(id);

        owner.setName(transientOwner.getName());
        owner.setYob(transientOwner.getYob());

        ownerService.updateOwner(owner);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOwner(@PathParam("ownerId") int id) {
        ownerService.deleteOwner(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Owner REST Service is running.";
    }
}
