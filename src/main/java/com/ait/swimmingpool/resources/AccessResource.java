package com.ait.swimmingpool.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.AccessBean;
import com.ait.swimmingpool.dao.AccessDAO;


@Path("/access")
public class AccessResource {
	AccessDAO dao = new AccessDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<AccessBean> findAll(){
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public AccessBean create(AccessBean access) {
		System.out.println("creating access");
		return dao.create(access);
	}
	
	@PUT @Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public AccessBean update(AccessBean access) {
		System.out.println("Updating access type");
		dao.update(access);
		return access;
	}
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void remove(@PathParam("id") int id) {
		dao.remove(id);
	}
}
