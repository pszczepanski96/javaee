package pl.pszczepanski.javaee.zad06.rest;



import pl.pszczepanski.javaee.zad06.domain.Producer;
import pl.pszczepanski.javaee.zad06.domain.Shoe;
import pl.pszczepanski.javaee.zad06.service.ShoeManager;


import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("shoe")
@Stateless
public class ShoeRestService {

   @Inject
    ShoeManager sm;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShoe(Shoe shoe) {

        Producer producer = new Producer("Adidas", "Germany");

        shoe.setProducer(producer);

        sm.addShoe(shoe);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{shoeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Shoe getShoe(@PathParam("shoeId") int id){
        return sm.getShoeById(id);
    }


    @PUT
    @Path("/{shoeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoe(@PathParam("shoeID") Long id, Shoe transientShoe){

        Shoe shoe = sm.getShoeById(id);

        shoe.setName(transientShoe.getName());
        shoe.setPrice(transientShoe.getPrice());
        shoe.setQuantity(transientShoe.getQuantity());


        sm.updateShoe(shoe);

        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Shoe REST Service is running...";
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shoe> getAll(){
        return sm.getAllShoes();
    }

    @DELETE
    @Path("/deleteAll")
    public Response deleteAll(){
        sm.deleteAllShoes();
        return Response.status(200).entity("Shoes deleted").build();
    }




}
