package com.ait.swimmingpool.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.ClassBean;
import com.ait.swimmingpool.dao.ClassDAO;

@Path("/class")
public class ClassResource {

	ClassDAO dao = new ClassDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ClassBean> findAll() {
		System.out.println("findAll");
		return dao.findAll();

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public ClassBean create(ClassBean addClass) {
		System.out.println("Adding class");
		return dao.create(addClass);

	}

	@DELETE
	@Path("{class_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void remove(@PathParam("class_id") String classId) {
		dao.remove(classId);
	}

}
