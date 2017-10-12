package com.aeromexico.sab.backend.ws.rest;

import com.aeromexico.sab.api.PerfilService;
import com.aeromexico.sab.dto.PerfilDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author alfredo
 */
@Stateless(name = "perfilRestService",mappedName = "perfilRestService",description = "perfil Rest Service")
@Path("/perfil")
public class PerfilRestService implements PerfilService{

	@Override
	public List<PerfilDTO> getAll() {
		List<PerfilDTO> perfilList = null;
		
		return perfilList;
	}
	
}
