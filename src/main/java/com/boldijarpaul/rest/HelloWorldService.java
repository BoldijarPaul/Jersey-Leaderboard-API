package com.boldijarpaul.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	public Response getMsg() {
		String output = "{ }";
		return Response.status(200).entity(output).build();
 
	}
 
}