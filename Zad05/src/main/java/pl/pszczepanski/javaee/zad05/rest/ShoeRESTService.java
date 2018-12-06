package pl.pszczepanski.javaee.zad05.rest;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.example.restwsdemo.domain.Shoe;
import com.example.restwsdemo.service.ShoeManager;

@Path("shoe")
@Stateless
public class ShoeRESTService {

	@Inject
	private ShoeManager sm;

	@GET
	@Path("/{shoeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shoe getShoe(@PathParam("personId") Integer id) {
		Shoe s = sm.getShoe(1);
		return s;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shoe> getShoes() {
		return sm.getAllShoes();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShoe(Shoe shoe) {
		sm.addShoe(shoe);

		return Response.status(201).entity("Shoe").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /shoe is running today!";
	}

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {return "Hello world Today!";}

	@DELETE
	public Response clearPersons() {
		sm.deleteAllShoes();
		return Response.status(200).build();
	}

}