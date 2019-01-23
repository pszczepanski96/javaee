package pl.pszczepanski.javaee.projekt.rest;

import pl.pszczepanski.javaee.projekt.domain.Shoes;
import pl.pszczepanski.javaee.projekt.service.ShoesService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("shoes")
public class ShoesRestService {

    @EJB
    ShoesService shoesService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Shoes> getAllShoes(){
        return shoesService.getAllShoes();
    }

    @GET
    @Path("/{shoesId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Shoes getShoes(@PathParam("shoesId") int id) {
        return shoesService.getShoes(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShoes(Shoes shoes) {
        shoesService.addShoes(shoes);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{shoesId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateShoes(@PathParam("shoesId") int id, Shoes transientShoes) {
        Shoes shoes = shoesService.getShoes(id);

        shoes.setName(transientShoes.getName());
        shoes.setSerialNumber(transientShoes.getSerialNumber());
        shoes.setSize(transientShoes.getSize());

        shoesService.updateShoes(shoes);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{shoesId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteShoes(@PathParam("shoesId") int id) {
        shoesService.deleteShoes(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Shoes REST Service is running.";
    }
}
