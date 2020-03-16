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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.TimetableBean;
import com.ait.swimmingpool.dao.TimetableDAO;

@Path("/timetable")
public class TimetableResource {
	TimetableDAO dao = new TimetableDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<TimetableBean> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public TimetableBean create(TimetableBean timetable) {
		System.out.println("creating timetable");
		return dao.create(timetable);
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public TimetableBean update(TimetableBean timetable) {
		System.out.println("Updating timetable");
		dao.update(timetable);
		return timetable;
	}

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("class_id") int id) {
		dao.remove(id);
	}
}
