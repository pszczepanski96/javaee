package pl.pszczepanski.javaee.zad06.rest;



import pl.pszczepanski.javaee.zad06.domain.Producer;
import pl.pszczepanski.javaee.zad06.domain.Shoe;
import pl.pszczepanski.javaee.zad06.service.ShoeManager;


import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        Producer producer= new Producer("Adidas");
        shoe.setProducer(producer);

        sm.addShoe(shoe);

        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Path("/{shoeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Shoe getShoe(@PathParam("shoeID") Long id){
        return sm.getShoeById(id);
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
        return Response.status(200).build();
    }




}
