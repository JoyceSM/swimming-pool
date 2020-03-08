package com.ait.swimmingpool.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.LoginBean;
import com.ait.swimmingpool.dao.LoginDAO;

@Path("/login")
public class LoginResource {

	LoginDAO dao = new LoginDAO();

	@GET
	@Path("/{username}")
	@Produces({ MediaType.APPLICATION_JSON })
	public LoginBean findByUsername(@PathParam("username") String username) {
		System.out.println("findByUsername: " + username);
		return dao.findByUsername(username);
	}

}
