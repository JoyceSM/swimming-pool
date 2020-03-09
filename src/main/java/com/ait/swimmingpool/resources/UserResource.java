package com.ait.swimmingpool.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.UserBean;
import com.ait.swimmingpool.dao.UserDAO;

@Path("/user")
public class UserResource {
	UserDAO dao = new UserDAO();
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserBean create(UserBean user) {
		System.out.println("creating user");
		return dao.create(user);
	}
}
