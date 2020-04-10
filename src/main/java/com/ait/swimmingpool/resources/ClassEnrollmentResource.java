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

import com.ait.swimmingpool.bean.ClassEnrollmentBean;
import com.ait.swimmingpool.dao.ClassEnrollmentDAO;

@Path("/enrollment")
public class ClassEnrollmentResource {
	ClassEnrollmentDAO dao = new ClassEnrollmentDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ClassEnrollmentBean> findAll(){
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClassEnrollmentBean create(ClassEnrollmentBean enrollment) {
		System.out.println("creating enrollment");
		return dao.create(enrollment);
	}
	
	@PUT @Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClassEnrollmentBean update(ClassEnrollmentBean enrollment) {
		System.out.println("Updating enrollment");
		dao.update(enrollment);
		return enrollment;
	}
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void remove(@PathParam("user_id") int id) {
		dao.remove(id);
	}
}
