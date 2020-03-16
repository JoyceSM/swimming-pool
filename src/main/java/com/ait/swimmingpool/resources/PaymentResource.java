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

import com.ait.swimmingpool.bean.PaymentBean;
import com.ait.swimmingpool.dao.PaymentDAO;

@Path("/payment")
public class PaymentResource {
	PaymentDAO dao = new PaymentDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PaymentBean> findAll(){
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PaymentBean create(PaymentBean payment) {
		System.out.println("creating payment");
		return dao.create(payment);
	}
	
	@PUT @Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PaymentBean update(PaymentBean payment) {
		System.out.println("Updating payment");
		dao.update(payment);
		return payment;
	}
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void remove(@PathParam("id") int id) {
		dao.remove(id);
	}
}
