package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Pais;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table pais.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class PaisAssembler {    
    
    /** 
     * Private Constructor
     */
    private PaisAssembler() {
    }

    public static Pais buildJpaEntity(PaisDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Pais jpaEntity = new Pais();

        jpaEntity.setIdPais( dtoEntity.getIdPais()); // normal
        jpaEntity.setCvePais( dtoEntity.getCvePais()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setIdRegion( dtoEntity.getIdRegion());
        jpaEntity.setRegion( RegionAssembler.buildJpaEntity( regionDTO ));
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Pais> buildJpaEntityList(List<PaisDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Pais> jpaEntityList = new ArrayList<>();
		Pais jpaEntity = null;
		for(PaisDTO dtoEntity: dtoEntityList){
			jpaEntity = new Pais();
            jpaEntity.setIdPais( dtoEntity.getIdPais());
            jpaEntity.setCvePais( dtoEntity.getCvePais());
            jpaEntity.setNombre( dtoEntity.getNombre());
            RegionDTO regionDTO = new RegionDTO();
            regionDTO.setIdRegion( dtoEntity.getIdRegion());
            jpaEntity.setRegion( RegionAssembler.buildJpaEntity( regionDTO ));
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static PaisDTO buildDTOEntity(Pais jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        PaisDTO dtoEntity =  new PaisDTO();		

        dtoEntity.setIdPais( jpaEntity.getIdPais() ); // primitive
        dtoEntity.setCvePais( jpaEntity.getCvePais() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        //Not Embedable: IdRegion -> Region, FTable: region, HyperName:region
        dtoEntity.setIdRegion( jpaEntity.getRegion()!=null?jpaEntity.getRegion().getIdRegion():null);
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<PaisDTO> buildDTOEntityList(List<Pais> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<PaisDTO> dtoEntityList = new ArrayList<>();
        PaisDTO dtoEntity =  null;
		for(Pais jpaEntity: jpaEntityList){
			dtoEntity =  new PaisDTO();
            dtoEntity.setIdPais( jpaEntity.getIdPais() );
            dtoEntity.setCvePais( jpaEntity.getCvePais() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            //Not Embedable: IdRegion -> Region, FTable: region, HyperName:region
            dtoEntity.setIdRegion( jpaEntity.getRegion()!=null?jpaEntity.getRegion().getIdRegion():null);
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
