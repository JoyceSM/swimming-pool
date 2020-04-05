package com.ait.swimmingpool.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ait.swimmingpool.bean.ClassTimeBean;
import com.ait.swimmingpool.dao.ClassTimeDAO;

@Path("/classTime")
public class ClassTimeResource {
	
	private ClassTimeDAO  ctd = new ClassTimeDAO ();
	
	@GET
	@Path("{day}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ClassTimeBean> findByDayOfWeek(@PathParam("day")String day) {
		System.out.println("findByDayOfWeek");
	return ctd.findByDayOfWeek(day);

	}


}
