package client;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.Scanner;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Client;

public class WebServiceClient {

	static final String REST_URI = "http://localhost:9999/WebService";
	static final String SERVICE_NAME = "/kalkulacka/sectixml";

	
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		URI service_Uri = UriBuilder.fromUri(REST_URI).build();
		WebTarget web_target = client.target(service_Uri);
		
		System.out.println("Zadej první číslo k sečtení:");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in, "Windows-1250");
		
		int a = Integer.parseInt(sc.nextLine());
		
		System.out.println("Zadej druhé číslo k sečtení:");
		int b = Integer.parseInt(sc.nextLine());
		
		System.out.println(web_target.path(SERVICE_NAME).queryParam("cislo1", a).queryParam("cislo2", b).toString());
		
		String vysledek = web_target.path(SERVICE_NAME).queryParam("cislo1", a).queryParam("cislo2", b).request().accept(MediaType.TEXT_XML).get(String.class);
		
		
		System.out.println(vysledek);

	}

}
