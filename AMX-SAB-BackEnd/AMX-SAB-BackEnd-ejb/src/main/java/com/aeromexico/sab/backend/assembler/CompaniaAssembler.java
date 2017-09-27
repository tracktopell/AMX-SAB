package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Compania;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table compania.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class CompaniaAssembler {    
    
    /** 
     * Private Constructor
     */
    private CompaniaAssembler() {
    }

    public static Compania buildJpaEntity(CompaniaDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Compania jpaEntity = new Compania();

        jpaEntity.setIdCompania( dtoEntity.getIdCompania()); // normal
        jpaEntity.setCveCompania( dtoEntity.getCveCompania()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Compania> buildJpaEntityList(List<CompaniaDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Compania> jpaEntityList = new ArrayList<>();
		Compania jpaEntity = null;
		for(CompaniaDTO dtoEntity: dtoEntityList){
			jpaEntity = new Compania();
            jpaEntity.setIdCompania( dtoEntity.getIdCompania());
            jpaEntity.setCveCompania( dtoEntity.getCveCompania());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static CompaniaDTO buildDTOEntity(Compania jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        CompaniaDTO dtoEntity =  new CompaniaDTO();		

        dtoEntity.setIdCompania( jpaEntity.getIdCompania() ); // primitive
        dtoEntity.setCveCompania( jpaEntity.getCveCompania() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<CompaniaDTO> buildDTOEntityList(List<Compania> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<CompaniaDTO> dtoEntityList = new ArrayList<>();
        CompaniaDTO dtoEntity =  null;
		for(Compania jpaEntity: jpaEntityList){
			dtoEntity =  new CompaniaDTO();
            dtoEntity.setIdCompania( jpaEntity.getIdCompania() );
            dtoEntity.setCveCompania( jpaEntity.getCveCompania() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
