package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.TipoEquipoAvion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table tipo_equipo_avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class TipoEquipoAvionAssembler {    
    
    /** 
     * Private Constructor
     */
    private TipoEquipoAvionAssembler() {
    }

    public static TipoEquipoAvion buildJpaEntity(TipoEquipoAvionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		TipoEquipoAvion jpaEntity = new TipoEquipoAvion();

        jpaEntity.setIdTipoEquipoAvion( dtoEntity.getIdTipoEquipoAvion()); // normal
        ModeloAvionDTO modeloAvionDTO = new ModeloAvionDTO();
        modeloAvionDTO.setIdModeloAvion( dtoEntity.getIdModeloAvion());
        jpaEntity.setModeloAvion( ModeloAvionAssembler.buildJpaEntity( modeloAvionDTO ));
        jpaEntity.setTotalAviones( dtoEntity.getTotalAviones()); // normal
        jpaEntity.setTipoEquipo( dtoEntity.getTipoEquipo()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<TipoEquipoAvion> buildJpaEntityList(List<TipoEquipoAvionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<TipoEquipoAvion> jpaEntityList = new ArrayList<>();
		TipoEquipoAvion jpaEntity = null;
		for(TipoEquipoAvionDTO dtoEntity: dtoEntityList){
			jpaEntity = new TipoEquipoAvion();
            jpaEntity.setIdTipoEquipoAvion( dtoEntity.getIdTipoEquipoAvion());
            ModeloAvionDTO modeloAvionDTO = new ModeloAvionDTO();
            modeloAvionDTO.setIdModeloAvion( dtoEntity.getIdModeloAvion());
            jpaEntity.setModeloAvion( ModeloAvionAssembler.buildJpaEntity( modeloAvionDTO ));
            jpaEntity.setTotalAviones( dtoEntity.getTotalAviones());
            jpaEntity.setTipoEquipo( dtoEntity.getTipoEquipo());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static TipoEquipoAvionDTO buildDTOEntity(TipoEquipoAvion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        TipoEquipoAvionDTO dtoEntity =  new TipoEquipoAvionDTO();		

        dtoEntity.setIdTipoEquipoAvion( jpaEntity.getIdTipoEquipoAvion() ); // primitive
        //Not Embedable: IdModeloAvion -> ModeloAvion, FTable: modelo_avion, HyperName:modelo_avion
        dtoEntity.setIdModeloAvion( jpaEntity.getModeloAvion()!=null?jpaEntity.getModeloAvion().getIdModeloAvion():null);
        dtoEntity.setTotalAviones( jpaEntity.getTotalAviones() ); // primitive
        dtoEntity.setTipoEquipo( jpaEntity.getTipoEquipo() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<TipoEquipoAvionDTO> buildDTOEntityList(List<TipoEquipoAvion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<TipoEquipoAvionDTO> dtoEntityList = new ArrayList<>();
        TipoEquipoAvionDTO dtoEntity =  null;
		for(TipoEquipoAvion jpaEntity: jpaEntityList){
			dtoEntity =  new TipoEquipoAvionDTO();
            dtoEntity.setIdTipoEquipoAvion( jpaEntity.getIdTipoEquipoAvion() );
            //Not Embedable: IdModeloAvion -> ModeloAvion, FTable: modelo_avion, HyperName:modelo_avion
            dtoEntity.setIdModeloAvion( jpaEntity.getModeloAvion()!=null?jpaEntity.getModeloAvion().getIdModeloAvion():null);
            dtoEntity.setTotalAviones( jpaEntity.getTotalAviones() );
            dtoEntity.setTipoEquipo( jpaEntity.getTipoEquipo() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
