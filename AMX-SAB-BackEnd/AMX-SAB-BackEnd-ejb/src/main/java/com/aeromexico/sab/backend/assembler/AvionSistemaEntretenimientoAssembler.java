package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.AvionSistemaEntretenimiento;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table avion_sistema_entretenimiento.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class AvionSistemaEntretenimientoAssembler {    
    
    /** 
     * Private Constructor
     */
    private AvionSistemaEntretenimientoAssembler() {
    }

    public static AvionSistemaEntretenimiento buildJpaEntity(AvionSistemaEntretenimientoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		AvionSistemaEntretenimiento jpaEntity = new AvionSistemaEntretenimiento();

        jpaEntity.setIdAvionSistemaEntretenimiento( dtoEntity.getIdAvionSistemaEntretenimiento()); // normal
        AvionDTO avionDTO = new AvionDTO();
        avionDTO.setIdAvion( dtoEntity.getIdAvion());
        jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
        SistemaEntretenimientoDTO sistemaEntretenimientoDTO = new SistemaEntretenimientoDTO();
        sistemaEntretenimientoDTO.setIdSistemaEntretenimiento( dtoEntity.getIdSistemaEntretenimiento());
        jpaEntity.setSistemaEntretenimiento( SistemaEntretenimientoAssembler.buildJpaEntity( sistemaEntretenimientoDTO ));

        return jpaEntity;
    }

    public static List<AvionSistemaEntretenimiento> buildJpaEntityList(List<AvionSistemaEntretenimientoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<AvionSistemaEntretenimiento> jpaEntityList = new ArrayList<>();
		AvionSistemaEntretenimiento jpaEntity = null;
		for(AvionSistemaEntretenimientoDTO dtoEntity: dtoEntityList){
			jpaEntity = new AvionSistemaEntretenimiento();
            jpaEntity.setIdAvionSistemaEntretenimiento( dtoEntity.getIdAvionSistemaEntretenimiento());
            AvionDTO avionDTO = new AvionDTO();
            avionDTO.setIdAvion( dtoEntity.getIdAvion());
            jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
            SistemaEntretenimientoDTO sistemaEntretenimientoDTO = new SistemaEntretenimientoDTO();
            sistemaEntretenimientoDTO.setIdSistemaEntretenimiento( dtoEntity.getIdSistemaEntretenimiento());
            jpaEntity.setSistemaEntretenimiento( SistemaEntretenimientoAssembler.buildJpaEntity( sistemaEntretenimientoDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static AvionSistemaEntretenimientoDTO buildDTOEntity(AvionSistemaEntretenimiento jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        AvionSistemaEntretenimientoDTO dtoEntity =  new AvionSistemaEntretenimientoDTO();		

        dtoEntity.setIdAvionSistemaEntretenimiento( jpaEntity.getIdAvionSistemaEntretenimiento() ); // primitive
        //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
        dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
        //Not Embedable: IdSistemaEntretenimiento -> SistemaEntretenimiento, FTable: sistema_entretenimiento, HyperName:sistema_entretenimiento
        dtoEntity.setIdSistemaEntretenimiento( jpaEntity.getSistemaEntretenimiento()!=null?jpaEntity.getSistemaEntretenimiento().getIdSistemaEntretenimiento():null);

        return dtoEntity;
    }

	public static List<AvionSistemaEntretenimientoDTO> buildDTOEntityList(List<AvionSistemaEntretenimiento> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<AvionSistemaEntretenimientoDTO> dtoEntityList = new ArrayList<>();
        AvionSistemaEntretenimientoDTO dtoEntity =  null;
		for(AvionSistemaEntretenimiento jpaEntity: jpaEntityList){
			dtoEntity =  new AvionSistemaEntretenimientoDTO();
            dtoEntity.setIdAvionSistemaEntretenimiento( jpaEntity.getIdAvionSistemaEntretenimiento() );
            //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
            dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
            //Not Embedable: IdSistemaEntretenimiento -> SistemaEntretenimiento, FTable: sistema_entretenimiento, HyperName:sistema_entretenimiento
            dtoEntity.setIdSistemaEntretenimiento( jpaEntity.getSistemaEntretenimiento()!=null?jpaEntity.getSistemaEntretenimiento().getIdSistemaEntretenimiento():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
