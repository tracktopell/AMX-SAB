package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Area;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table area.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/04 07:27
 */

public class AreaAssembler {    
    
    /** 
     * Private Constructor
     */
    private AreaAssembler() {
    }

    public static Area buildJpaEntity(AreaDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Area jpaEntity = new Area();

        jpaEntity.setIdArea( dtoEntity.getIdArea()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setClave( dtoEntity.getClave()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Area> buildJpaEntityList(List<AreaDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Area> jpaEntityList = new ArrayList<>();
		Area jpaEntity = null;
		for(AreaDTO dtoEntity: dtoEntityList){
			jpaEntity = new Area();
            jpaEntity.setIdArea( dtoEntity.getIdArea());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setClave( dtoEntity.getClave());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static AreaDTO buildDTOEntity(Area jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        AreaDTO dtoEntity =  new AreaDTO();		

        dtoEntity.setIdArea( jpaEntity.getIdArea() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setClave( jpaEntity.getClave() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<AreaDTO> buildDTOEntityList(List<Area> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<AreaDTO> dtoEntityList = new ArrayList<>();
        AreaDTO dtoEntity =  null;
		for(Area jpaEntity: jpaEntityList){
			dtoEntity =  new AreaDTO();
            dtoEntity.setIdArea( jpaEntity.getIdArea() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setClave( jpaEntity.getClave() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
