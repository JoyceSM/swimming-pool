package com.ait.swimmingpool.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.UserBean;
import com.ait.swimmingpool.dao.LoginDAO;
import com.ait.swimmingpool.dao.UserDAO;

@Path("/user")
public class UserResource {
	UserDAO dao = new UserDAO();
	LoginDAO ldao = new LoginDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<UserBean> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserBean create(UserBean user) {
		System.out.println("creating user");
		dao.create(user);
		ldao.addLogin(user.getEmail(), user.getCredentials().getPassword(), user.getCredentials().getAccessId());
		return user;
	}

}
