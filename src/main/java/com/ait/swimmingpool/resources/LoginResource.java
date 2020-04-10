package com.ait.swimmingpool.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.LoginBean;
import com.ait.swimmingpool.constants.AccessType;
import com.ait.swimmingpool.dao.LoginDAO;

@Path("/login")
public class LoginResource {

	private LoginDAO dao = new LoginDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Map<String, Object> findByUsername(@QueryParam("username") String username, @QueryParam("password") String password) {
		System.out.println("findByUsername: " + username);
		LoginBean login = dao.findByUsername(username);
		
		Map<String, Object> loginDetails = new HashMap<>();
		if (login != null && login.getPassword().equals(password)) {
			loginDetails.put("accessType", login.getAccessId());
			loginDetails.put("username", login.getUsername());
			return loginDetails;
		}
		loginDetails.put("accessType", AccessType.NOT_AUTHENTICATED.getAccessType());
		return loginDetails;
	}

}
