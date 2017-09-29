package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Clase;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table clase.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class ClaseAssembler {    
    
    /** 
     * Private Constructor
     */
    private ClaseAssembler() {
    }

    public static Clase buildJpaEntity(ClaseDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Clase jpaEntity = new Clase();

        jpaEntity.setIdClase( dtoEntity.getIdClase()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setClave( dtoEntity.getClave()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Clase> buildJpaEntityList(List<ClaseDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Clase> jpaEntityList = new ArrayList<>();
		Clase jpaEntity = null;
		for(ClaseDTO dtoEntity: dtoEntityList){
			jpaEntity = new Clase();
            jpaEntity.setIdClase( dtoEntity.getIdClase());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setClave( dtoEntity.getClave());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ClaseDTO buildDTOEntity(Clase jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ClaseDTO dtoEntity =  new ClaseDTO();		

        dtoEntity.setIdClase( jpaEntity.getIdClase() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setClave( jpaEntity.getClave() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<ClaseDTO> buildDTOEntityList(List<Clase> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ClaseDTO> dtoEntityList = new ArrayList<>();
        ClaseDTO dtoEntity =  null;
		for(Clase jpaEntity: jpaEntityList){
			dtoEntity =  new ClaseDTO();
            dtoEntity.setIdClase( jpaEntity.getIdClase() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setClave( jpaEntity.getClave() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
