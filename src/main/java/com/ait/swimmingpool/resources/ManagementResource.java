package com.ait.swimmingpool.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/management")
public class ManagementResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String findAll() {
		return "Hello World!";
	}

}
