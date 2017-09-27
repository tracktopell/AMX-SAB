package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Ciudad;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table ciudad.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class CiudadAssembler {    
    
    /** 
     * Private Constructor
     */
    private CiudadAssembler() {
    }

    public static Ciudad buildJpaEntity(CiudadDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Ciudad jpaEntity = new Ciudad();

        jpaEntity.setIdCiudad( dtoEntity.getIdCiudad()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setIdPais( dtoEntity.getIdPais());
        jpaEntity.setPais( PaisAssembler.buildJpaEntity( paisDTO ));
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Ciudad> buildJpaEntityList(List<CiudadDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Ciudad> jpaEntityList = new ArrayList<>();
		Ciudad jpaEntity = null;
		for(CiudadDTO dtoEntity: dtoEntityList){
			jpaEntity = new Ciudad();
            jpaEntity.setIdCiudad( dtoEntity.getIdCiudad());
            jpaEntity.setNombre( dtoEntity.getNombre());
            PaisDTO paisDTO = new PaisDTO();
            paisDTO.setIdPais( dtoEntity.getIdPais());
            jpaEntity.setPais( PaisAssembler.buildJpaEntity( paisDTO ));
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static CiudadDTO buildDTOEntity(Ciudad jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        CiudadDTO dtoEntity =  new CiudadDTO();		

        dtoEntity.setIdCiudad( jpaEntity.getIdCiudad() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        //Not Embedable: IdPais -> Pais, FTable: pais, HyperName:pais
        dtoEntity.setIdPais( jpaEntity.getPais()!=null?jpaEntity.getPais().getIdPais():null);
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<CiudadDTO> buildDTOEntityList(List<Ciudad> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<CiudadDTO> dtoEntityList = new ArrayList<>();
        CiudadDTO dtoEntity =  null;
		for(Ciudad jpaEntity: jpaEntityList){
			dtoEntity =  new CiudadDTO();
            dtoEntity.setIdCiudad( jpaEntity.getIdCiudad() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            //Not Embedable: IdPais -> Pais, FTable: pais, HyperName:pais
            dtoEntity.setIdPais( jpaEntity.getPais()!=null?jpaEntity.getPais().getIdPais():null);
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
