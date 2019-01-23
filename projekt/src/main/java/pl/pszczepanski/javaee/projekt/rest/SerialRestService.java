package pl.pszczepanski.javaee.projekt.rest;

import pl.pszczepanski.javaee.projekt.domain.Serial;
import pl.pszczepanski.javaee.projekt.service.SerialService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("serial")
public class SerialRestService {
    @EJB
    SerialService serialService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Serial> getAllSerial(){
        return serialService.getAllSerial();
    }

    @GET
    @Path("/{serialId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Serial getSerial(@PathParam("serialId") int id) {
        return serialService.getSerial(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSerial(Serial serial) {
        serialService.addSerial(serial);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{serialId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSerial(@PathParam("serialId") int id,Serial transientSerial) {
        Serial serial = serialService.getSerial(id);

        serial.setSerialNr(transientSerial.getSerialNr());

        serialService.updateSerial(serial);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{serialId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSerial(@PathParam("serialId") int id) {
        serialService.deleteSerial(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Serial REST Service is running.";
    }
}
