package pl.pszczepanski.javaee.zad06.rest;

import pl.pszczepanski.javaee.zad06.domain.Producer;
import pl.pszczepanski.javaee.zad06.service.ProducerManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("producer")
public class ProducerRestService {
    @Inject
    ProducerManager pm;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShoe(Producer producer) {

        pm.addProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") int id){
        return pm.getProducerById(id);
    }


    @PUT
    @Path("/{producerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducer(@PathParam("producerID") Long id, Producer transientProducer){

        Producer producer = pm.getProducerById(id);

        producer.setName(transientProducer.getName());
        producer.setCountry(transientProducer.getCountry());



        pm.updateProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Producer REST Service is running...";
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producer> getAll(){
        return pm.getAllProducers();
    }

    @DELETE
    @Path("/deleteAll")
    public Response deleteAll(){
        pm.deleteAllProducers();
        return Response.status(200).entity("Producers deleted").build();
    }

}
