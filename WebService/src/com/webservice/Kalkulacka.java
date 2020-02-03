package com.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/kalkulacka")
public class Kalkulacka {


	@GET
	@Path("/sectixml")
	@Produces(MediaType.TEXT_XML)
	public String secti(@QueryParam("cislo1") int i, @QueryParam("cislo2") int j) {
		return "<?xml version=\"1.0\"?>" + "<sum>"
				+ "<firstNumber>" + i + "</firstNumber>"
				+ "<secondNumber>" + j + "</secondNumber>"
				+ "<result>" + (i+j) + "</result>"
				+ "</sum>";
	}

	@GET
	@Path("/sectihtml")
	@Produces(MediaType.TEXT_HTML)
	public String sectiHTML(@QueryParam("cislo1") int i, @QueryParam("cislo2") int j) {
		return "<html>" + "<head>" + "<title>" +"Sum" + "</title>" + "</head>"
				+ "<body>"
				+ "<p>fisrtNumber: " + i + "</p>"
				+ "<p>secondNumber: " + j + "</p>"
				+ "<p>sum: " + (i+j) + "</p>"
				+ "</body>" + "</html>";
	}
}
