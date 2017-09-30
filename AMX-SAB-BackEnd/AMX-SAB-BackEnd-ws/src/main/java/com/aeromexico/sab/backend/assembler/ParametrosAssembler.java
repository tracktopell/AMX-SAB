package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Parametros;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table parametros.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/30 07:39
 */

public class ParametrosAssembler {    
    
    /** 
     * Private Constructor
     */
    private ParametrosAssembler() {
    }

    public static Parametros buildJpaEntity(ParametrosDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Parametros jpaEntity = new Parametros();

        jpaEntity.setIdParametro( dtoEntity.getIdParametro()); // normal
        jpaEntity.setClave( dtoEntity.getClave()); // normal
        jpaEntity.setValor( dtoEntity.getValor()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Parametros> buildJpaEntityList(List<ParametrosDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Parametros> jpaEntityList = new ArrayList<>();
		Parametros jpaEntity = null;
		for(ParametrosDTO dtoEntity: dtoEntityList){
			jpaEntity = new Parametros();
            jpaEntity.setIdParametro( dtoEntity.getIdParametro());
            jpaEntity.setClave( dtoEntity.getClave());
            jpaEntity.setValor( dtoEntity.getValor());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ParametrosDTO buildDTOEntity(Parametros jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ParametrosDTO dtoEntity =  new ParametrosDTO();		

        dtoEntity.setIdParametro( jpaEntity.getIdParametro() ); // primitive
        dtoEntity.setClave( jpaEntity.getClave() ); // primitive
        dtoEntity.setValor( jpaEntity.getValor() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<ParametrosDTO> buildDTOEntityList(List<Parametros> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ParametrosDTO> dtoEntityList = new ArrayList<>();
        ParametrosDTO dtoEntity =  null;
		for(Parametros jpaEntity: jpaEntityList){
			dtoEntity =  new ParametrosDTO();
            dtoEntity.setIdParametro( jpaEntity.getIdParametro() );
            dtoEntity.setClave( jpaEntity.getClave() );
            dtoEntity.setValor( jpaEntity.getValor() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
