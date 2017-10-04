package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.SistemaEntretenimiento;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table sistema_entretenimiento.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/04 07:27
 */

public class SistemaEntretenimientoAssembler {    
    
    /** 
     * Private Constructor
     */
    private SistemaEntretenimientoAssembler() {
    }

    public static SistemaEntretenimiento buildJpaEntity(SistemaEntretenimientoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		SistemaEntretenimiento jpaEntity = new SistemaEntretenimiento();

        jpaEntity.setIdSistemaEntretenimiento( dtoEntity.getIdSistemaEntretenimiento()); // normal
        jpaEntity.setTipo( dtoEntity.getTipo()); // normal
        jpaEntity.setVersion( dtoEntity.getVersion()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<SistemaEntretenimiento> buildJpaEntityList(List<SistemaEntretenimientoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<SistemaEntretenimiento> jpaEntityList = new ArrayList<>();
		SistemaEntretenimiento jpaEntity = null;
		for(SistemaEntretenimientoDTO dtoEntity: dtoEntityList){
			jpaEntity = new SistemaEntretenimiento();
            jpaEntity.setIdSistemaEntretenimiento( dtoEntity.getIdSistemaEntretenimiento());
            jpaEntity.setTipo( dtoEntity.getTipo());
            jpaEntity.setVersion( dtoEntity.getVersion());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static SistemaEntretenimientoDTO buildDTOEntity(SistemaEntretenimiento jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        SistemaEntretenimientoDTO dtoEntity =  new SistemaEntretenimientoDTO();		

        dtoEntity.setIdSistemaEntretenimiento( jpaEntity.getIdSistemaEntretenimiento() ); // primitive
        dtoEntity.setTipo( jpaEntity.getTipo() ); // primitive
        dtoEntity.setVersion( jpaEntity.getVersion() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<SistemaEntretenimientoDTO> buildDTOEntityList(List<SistemaEntretenimiento> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<SistemaEntretenimientoDTO> dtoEntityList = new ArrayList<>();
        SistemaEntretenimientoDTO dtoEntity =  null;
		for(SistemaEntretenimiento jpaEntity: jpaEntityList){
			dtoEntity =  new SistemaEntretenimientoDTO();
            dtoEntity.setIdSistemaEntretenimiento( jpaEntity.getIdSistemaEntretenimiento() );
            dtoEntity.setTipo( jpaEntity.getTipo() );
            dtoEntity.setVersion( jpaEntity.getVersion() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
