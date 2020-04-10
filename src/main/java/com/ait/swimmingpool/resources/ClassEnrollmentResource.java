package com.ait.swimmingpool.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ait.swimmingpool.bean.PaymentBean;
import com.ait.swimmingpool.dao.ClassEnrollmentDAO;
import com.ait.swimmingpool.dao.PaymentDAO;

@Path("/enrollment")
public class ClassEnrollmentResource {
	
	
	private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	private ClassEnrollmentDAO dao = new ClassEnrollmentDAO();
	private PaymentDAO pdao = new PaymentDAO();
	
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
		ClassEnrollmentBean result = dao.create(enrollment);
		if(enrollment.getPaymentId() == 0) {
			PaymentBean payment = new PaymentBean();
			payment.setAmount(enrollment.getPrice());
			payment.setUserId(enrollment.getUserId());
			payment.setPaymentDate(DATE_FORMATTER.format(new Date()));
			pdao.create(payment);
		}
		return result;
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
