package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Region;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table region.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/30 07:39
 */

public class RegionAssembler {    
    
    /** 
     * Private Constructor
     */
    private RegionAssembler() {
    }

    public static Region buildJpaEntity(RegionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Region jpaEntity = new Region();

        jpaEntity.setIdRegion( dtoEntity.getIdRegion()); // normal
        jpaEntity.setCveRegion( dtoEntity.getCveRegion()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Region> buildJpaEntityList(List<RegionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Region> jpaEntityList = new ArrayList<>();
		Region jpaEntity = null;
		for(RegionDTO dtoEntity: dtoEntityList){
			jpaEntity = new Region();
            jpaEntity.setIdRegion( dtoEntity.getIdRegion());
            jpaEntity.setCveRegion( dtoEntity.getCveRegion());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static RegionDTO buildDTOEntity(Region jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        RegionDTO dtoEntity =  new RegionDTO();		

        dtoEntity.setIdRegion( jpaEntity.getIdRegion() ); // primitive
        dtoEntity.setCveRegion( jpaEntity.getCveRegion() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<RegionDTO> buildDTOEntityList(List<Region> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<RegionDTO> dtoEntityList = new ArrayList<>();
        RegionDTO dtoEntity =  null;
		for(Region jpaEntity: jpaEntityList){
			dtoEntity =  new RegionDTO();
            dtoEntity.setIdRegion( jpaEntity.getIdRegion() );
            dtoEntity.setCveRegion( jpaEntity.getCveRegion() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
