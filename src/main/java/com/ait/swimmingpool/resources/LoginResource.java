package com.ait.swimmingpool.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.LoginBean;
import com.ait.swimmingpool.dao.LoginDAO;

@Path("/login")
public class LoginResource {

	private static final int NOT_AUTHENTICATED = 0;
	LoginDAO dao = new LoginDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public int findByUsername(@QueryParam("username") String username, @QueryParam("password") String password) {
		System.out.println("findByUsername: " + username);
		LoginBean login = dao.findByUsername(username);

		if (login != null && login.getPassword().equals(password)) {
			return login.getAccessId();
		}
		return NOT_AUTHENTICATED;
	}

}
