package webservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;


@Path("/query-webservice")
public class QueryWebService {

	private static final Logger LOGGER = Logger.getLogger(QueryWebService.class);
	
	@GET
	@Path("/get-zaznamy")
	@Produces(MediaType.TEXT_XML)
	public String getZaznamy() {
		String zaznamyXml = "";
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ebookshop", "postgres", "Psql.3");
				Statement statement = connection.createStatement()){
			LOGGER.debug("Database connection initialized");
			
			ResultSet results = statement.executeQuery("select * from books order by author limit 100");
			LOGGER.debug("Database query performed");
			
			List<Kniha> zaznamy = new ArrayList<>();
			
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\"?>");
			sb.append("<knihy>");
			
			while(results.next()) {
				String nazev = results.getString("title");
				String autor = results.getString("author");
				BigDecimal cena = results.getBigDecimal("price");
				int mnozstvi = results.getInt("qty");
				
				sb.append("<kniha>");
				sb.append("<nazev>");
				sb.append(nazev);
				sb.append("</nazev>");
				sb.append("</kniha>");
				
				zaznamy.add(new Kniha(nazev, autor, cena, mnozstvi));
			}
			sb.append("</knihy>");
			zaznamyXml = sb.toString();
			LOGGER.debug("XML string assembled");
			
		}
		catch (SQLException ex){

			LOGGER.error("ERROR: SQL Exception: " + ex);
		}
		
		return zaznamyXml;
		
	}
}
