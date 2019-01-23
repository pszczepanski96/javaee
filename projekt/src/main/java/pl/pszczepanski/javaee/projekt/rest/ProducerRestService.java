package pl.pszczepanski.javaee.projekt.rest;

import pl.pszczepanski.javaee.projekt.domain.Producer;
import pl.pszczepanski.javaee.projekt.service.ProducerService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("producer")
public class ProducerRestService {


    @EJB
    ProducerService producerService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducer(){
        return producerService.getAllProducer();
    }

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") int id) {
        return producerService.getProducer(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {
        producerService.addProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{producerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducer(@PathParam("producerId") int id,Producer transientProducer) {
        Producer producer = producerService.getProducer(id);

        producer.setName(transientProducer.getName());
        producer.setCountry(transientProducer.getCountry());

        producerService.updateProducer(producer);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProducer(@PathParam("producerId") int id) {
        producerService.deleteProducer(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Producer REST Service is running.";
    }
}
