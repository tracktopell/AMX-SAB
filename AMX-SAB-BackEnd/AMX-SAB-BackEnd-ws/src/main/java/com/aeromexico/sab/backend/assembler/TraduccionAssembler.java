package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Traduccion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table traduccion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class TraduccionAssembler {    
    
    /** 
     * Private Constructor
     */
    private TraduccionAssembler() {
    }

    public static Traduccion buildJpaEntity(TraduccionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Traduccion jpaEntity = new Traduccion();

        jpaEntity.setIdTraduccion( dtoEntity.getIdTraduccion()); // normal
        jpaEntity.setNombreEntidad( dtoEntity.getNombreEntidad()); // normal
        jpaEntity.setIdEntidad( dtoEntity.getIdEntidad()); // normal
        jpaEntity.setCampo( dtoEntity.getCampo()); // normal
        jpaEntity.setValor( dtoEntity.getValor()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Traduccion> buildJpaEntityList(List<TraduccionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Traduccion> jpaEntityList = new ArrayList<>();
		Traduccion jpaEntity = null;
		for(TraduccionDTO dtoEntity: dtoEntityList){
			jpaEntity = new Traduccion();
            jpaEntity.setIdTraduccion( dtoEntity.getIdTraduccion());
            jpaEntity.setNombreEntidad( dtoEntity.getNombreEntidad());
            jpaEntity.setIdEntidad( dtoEntity.getIdEntidad());
            jpaEntity.setCampo( dtoEntity.getCampo());
            jpaEntity.setValor( dtoEntity.getValor());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static TraduccionDTO buildDTOEntity(Traduccion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        TraduccionDTO dtoEntity =  new TraduccionDTO();		

        dtoEntity.setIdTraduccion( jpaEntity.getIdTraduccion() ); // primitive
        dtoEntity.setNombreEntidad( jpaEntity.getNombreEntidad() ); // primitive
        dtoEntity.setIdEntidad( jpaEntity.getIdEntidad() ); // primitive
        dtoEntity.setCampo( jpaEntity.getCampo() ); // primitive
        dtoEntity.setValor( jpaEntity.getValor() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<TraduccionDTO> buildDTOEntityList(List<Traduccion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<TraduccionDTO> dtoEntityList = new ArrayList<>();
        TraduccionDTO dtoEntity =  null;
		for(Traduccion jpaEntity: jpaEntityList){
			dtoEntity =  new TraduccionDTO();
            dtoEntity.setIdTraduccion( jpaEntity.getIdTraduccion() );
            dtoEntity.setNombreEntidad( jpaEntity.getNombreEntidad() );
            dtoEntity.setIdEntidad( jpaEntity.getIdEntidad() );
            dtoEntity.setCampo( jpaEntity.getCampo() );
            dtoEntity.setValor( jpaEntity.getValor() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
