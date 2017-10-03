package com.aeromexico.sab.backend.ws.rest;

import com.aeromexico.sab.api.PerfilService;
import com.aeromexico.sab.backend.assembler.PerfilAssembler;
import com.aeromexico.sab.backend.entity.Perfil;

import com.aeromexico.sab.backend.remote.PerfilFacadeRemote;

import com.aeromexico.sab.dto.PerfilDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author alfredo.estrada
 */
@Stateless(name = "perfilServiceBean",mappedName = "perfilServiceBean",description = "perfil RS")
@Path("/perfil")
public class PerfilServiceBean implements PerfilService{
	/*
	java:global/AMX-SAB-BackEnd-ear-1.0/AMX-SAB-BackEnd-ejb-1.0/PerfilFacade
	*/
	@EJB(lookup = "java:global/AMX-SAB-BackEnd-ear-1.0/AMX-SAB-BackEnd-ejb-1.0/PerfilFacade") PerfilFacadeRemote perfilLB;
	
	@Path("/getAll")
	@GET
	@Produces("application/json")
	public List<PerfilDTO> getAll(){
		List<PerfilDTO> perfilDTOList = null;
		try {
			List<Perfil> list = perfilLB.findAll();
			perfilDTOList = PerfilAssembler.buildDTOEntityList(list);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
		}
		return perfilDTOList;
	}
}
