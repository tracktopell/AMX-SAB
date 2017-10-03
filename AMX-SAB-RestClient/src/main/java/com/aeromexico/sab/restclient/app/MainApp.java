package com.aeromexico.sab.restclient.app;

import com.aeromexico.sab.dto.PerfilDTO;
import com.aeromexico.sab.restclient.PerfilServiceClient;
import java.util.List;

/**
 *
 * @author alfredo.estrada
 */
public class MainApp {
	private static PerfilServiceClient personServiceClient;
	
	public static void main(String[] args) {
		personServiceClient = new PerfilServiceClient ("http://localhost:8080/TestArch4BackEnd-ws/restapi/person/getAll");
		List<PerfilDTO> personList = personServiceClient.getAll();
		
		for(PerfilDTO p: personList){
			System.err.println("->p:"+p);
		}
		
	}
}
