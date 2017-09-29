package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Perfil;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class PerfilAssembler {    
    
    /** 
     * Private Constructor
     */
    private PerfilAssembler() {
    }

    public static Perfil buildJpaEntity(PerfilDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Perfil jpaEntity = new Perfil();

        jpaEntity.setIdPerfil( dtoEntity.getIdPerfil()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Perfil> buildJpaEntityList(List<PerfilDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Perfil> jpaEntityList = new ArrayList<>();
		Perfil jpaEntity = null;
		for(PerfilDTO dtoEntity: dtoEntityList){
			jpaEntity = new Perfil();
            jpaEntity.setIdPerfil( dtoEntity.getIdPerfil());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static PerfilDTO buildDTOEntity(Perfil jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        PerfilDTO dtoEntity =  new PerfilDTO();		

        dtoEntity.setIdPerfil( jpaEntity.getIdPerfil() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<PerfilDTO> buildDTOEntityList(List<Perfil> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<PerfilDTO> dtoEntityList = new ArrayList<>();
        PerfilDTO dtoEntity =  null;
		for(Perfil jpaEntity: jpaEntityList){
			dtoEntity =  new PerfilDTO();
            dtoEntity.setIdPerfil( jpaEntity.getIdPerfil() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
