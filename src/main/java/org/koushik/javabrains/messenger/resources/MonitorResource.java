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
import org.koushik.javabrains.messenger.service.MonitorService;

//import com.sample.jersey.app.Account;
//import com.sample.jersey.app.Application;
//import com.sample.jersey.app.StormpathUtils;

@Path("/monitor")
public class MonitorResource {
	
	MonitorService monitorservice = new MonitorService();
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public List<PERFORMANCE_LOG> getPERFORMANCE_LOG(){
		//callstackservice.CallStackService();
		
		return monitorservice.getAllPERFORMANCE_LOG();
	}

	@POST
	@Produces({"application/xml", "application/json", "text/plain", "application/x-www-form-urlencoded"})
	@Consumes({"application/xml", "application/json", "text/plain", "application/x-www-form-urlencoded"})
	public void postPERFORMANCE_LOG(PERFORMANCE_LOG log){
		
		if(log.getmKPI_DESC().equals("Delete Monitored Scripts")){
			monitorservice.deleteAllMonitoredScripts();
		}else{
			monitorservice.addPERFORMANCE_LOG(log);
		}

	}
}
