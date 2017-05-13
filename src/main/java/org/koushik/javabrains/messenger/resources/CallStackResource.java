package org.koushik.javabrains.messenger.resources;

import java.net.URI;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.messenger.model.Graph_PERF_AVERAGES;
import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.model.PERFORMANCE_LOG;
import org.koushik.javabrains.messenger.model.PERF_AVERAGES;
import org.koushik.javabrains.messenger.service.CallStackService;

@Path("/callstack")
public class CallStackResource {
	
	CallStackService callstackservice = new CallStackService();
	
	@GET
	//@Path("/averages")
	public List<PERF_AVERAGES> getPERF_AVERAGES(){
		//callstackservice.CallStackService();
		
		return callstackservice.getAllPERF_AVERAGES();
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/post")
	public String postPERFORMANCE_LOG(PERFORMANCE_LOG log){
		
        System.out.println("First Name = "+log.getmPATH());
        System.out.println("Last Name  = "+log.getmKPI_DESC());
        return "ok";
	}
	
	
	

}
