package org.koushik.javabrains.messenger.resources;

import java.io.File;
import java.io.FileOutputStream;
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
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.messenger.service.CreateExlFileService;
@Path("/report")
public class CreateExlFileResource {
	
	CreateExlFileService createexlfileservice = new CreateExlFileService();
	
//	@GET
//	public FileOutputStream getExlFile(){
//		return createexlfileservice.generateExlFile();
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getExlFileResponse(){
		 File file = createexlfileservice.generateExlFile();
		 ResponseBuilder response = Response.ok((Object) file);
		 response.header("Content-Disposition", "attachment; filename=PerformanceTests.xlsx");
		 return response.build();
	}
}