package com.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World RESTful Jersey!";
	}

	@GET
	@Path("/xmlhello")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey"
				+ "</hello>";
	}

	@GET
	@Path("/htmlhello/{i}")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello(@PathParam("i") int i) {
		return "<html> " + "<head>" + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "</head>" + "<body><h1>" + "Hello World RESTful Jersey, number: " + i
				+ "</body></h1>" + "</html> ";
	}

}