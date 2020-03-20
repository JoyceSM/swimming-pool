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

import com.ait.swimmingpool.bean.ClassBean;
import com.ait.swimmingpool.bean.TimetableBean;
import com.ait.swimmingpool.dao.ClassDAO;
import com.ait.swimmingpool.dao.TimetableDAO;

@Path("/class")
public class ClassResource {

	private ClassDAO cdao = new ClassDAO();
	private TimetableDAO tdao = new TimetableDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ClassBean> findAll() {
		System.out.println("findAll");
		return cdao.findAll();

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public ClassBean create(ClassBean addClass) {
		System.out.println("Adding class");
		ClassBean cb = cdao.create(addClass);
		for (TimetableBean timeBean : cb.getTimetable()) {
			if (timeBean.getClassTime() != null && !timeBean.getClassTime().isEmpty()) {
				timeBean.setClassId(addClass.getClassId());
				tdao.create(timeBean);
			}
		}
		return cb;

	}

	@DELETE
	@Path("{class_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void remove(@PathParam("class_id") String classId) {
		tdao.remove(classId);
		cdao.remove(classId);
	}

	@GET
	@Path("{class_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ClassBean findById(@PathParam("class_id") String classId) {
		List<TimetableBean> timeBean = tdao.findById(classId);
		ClassBean cb = cdao.findById(classId);
		cb.setTimetable(timeBean);
		return cb;

	}

	@PUT
	@Path("{class_id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public ClassBean update(ClassBean classObj, @PathParam("class_id") String class_id) {
		tdao.remove(class_id);
		cdao.update(classObj);
		for (TimetableBean timeBean : classObj.getTimetable()) {
			if (timeBean.getClassTime() != null && !timeBean.getClassTime().isEmpty()) {
				timeBean.setClassId(classObj.getClassId());
				tdao.create(timeBean);
			}
		}
		return classObj;
	}
}
