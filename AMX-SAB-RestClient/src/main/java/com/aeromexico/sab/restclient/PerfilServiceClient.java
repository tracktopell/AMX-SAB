package com.aeromexico.sab.restclient;

import com.aeromexico.sab.api.PerfilService;
import com.aeromexico.sab.dto.PerfilDTO;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alfredo.estrada
 */
public class PerfilServiceClient extends JacksonServiceProxy implements PerfilService{

	public PerfilServiceClient(String serviceEndpointURL) {
		super(serviceEndpointURL);
	}
	
	@Override
	public List<PerfilDTO> getAll() {
		List<PerfilDTO> l = null;
		WebTarget target = client.target(serviceEndpointURL);
				
		String r = target.request(MediaType.APPLICATION_JSON).get(String.class);

		ObjectMapper mapper = new ObjectMapper();
		try{
			l = mapper.readValue(r, new TypeReference<List<PerfilDTO>>(){});
		}catch(IOException ioe){
			ioe.printStackTrace(System.err);
		}

		return l;
	}
	
}
