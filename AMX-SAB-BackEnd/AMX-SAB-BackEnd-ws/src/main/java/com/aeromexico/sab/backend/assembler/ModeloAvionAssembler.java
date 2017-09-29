package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.ModeloAvion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table modelo_avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class ModeloAvionAssembler {    
    
    /** 
     * Private Constructor
     */
    private ModeloAvionAssembler() {
    }

    public static ModeloAvion buildJpaEntity(ModeloAvionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		ModeloAvion jpaEntity = new ModeloAvion();

        jpaEntity.setIdModeloAvion( dtoEntity.getIdModeloAvion()); // normal
        jpaEntity.setModelo( dtoEntity.getModelo()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal
        // Assembler delegation: fTable.pk=id_parametro
        ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
        dtoParametrosDTO.setIdParametro( dtoEntity.getTipoCabina());
        jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
        CompaniaDTO companiaDTO = new CompaniaDTO();
        companiaDTO.setIdCompania( dtoEntity.getIdCompania());
        jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
        // Assembler delegation: fTable.pk=id_parametro
        ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
        dtoParametrosDTO.setIdParametro( dtoEntity.getIdFabricante());
        jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
        jpaEntity.setEstaus( dtoEntity.getEstaus()); // normal

        return jpaEntity;
    }

    public static List<ModeloAvion> buildJpaEntityList(List<ModeloAvionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<ModeloAvion> jpaEntityList = new ArrayList<>();
		ModeloAvion jpaEntity = null;
		for(ModeloAvionDTO dtoEntity: dtoEntityList){
			jpaEntity = new ModeloAvion();
            jpaEntity.setIdModeloAvion( dtoEntity.getIdModeloAvion());
            jpaEntity.setModelo( dtoEntity.getModelo());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
            // Assembler delegation: fTable.pk=id_parametro
            ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
            dtoParametrosDTO.setIdParametro( dtoEntity.getTipoCabina());
            jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
            CompaniaDTO companiaDTO = new CompaniaDTO();
            companiaDTO.setIdCompania( dtoEntity.getIdCompania());
            jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
            // Assembler delegation: fTable.pk=id_parametro
            ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
            dtoParametrosDTO.setIdParametro( dtoEntity.getIdFabricante());
            jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
            jpaEntity.setEstaus( dtoEntity.getEstaus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ModeloAvionDTO buildDTOEntity(ModeloAvion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ModeloAvionDTO dtoEntity =  new ModeloAvionDTO();		

        dtoEntity.setIdModeloAvion( jpaEntity.getIdModeloAvion() ); // primitive
        dtoEntity.setModelo( jpaEntity.getModelo() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive
        //Not Embedable: TipoCabina -> Parametros, FTable: parametros, HyperName:null
        dtoEntity.setTipoCabina( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
        //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
        dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
        //Not Embedable: IdFabricante -> Parametros, FTable: parametros, HyperName:null
        dtoEntity.setIdFabricante( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
        dtoEntity.setEstaus( jpaEntity.getEstaus() ); // primitive

        return dtoEntity;
    }

	public static List<ModeloAvionDTO> buildDTOEntityList(List<ModeloAvion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ModeloAvionDTO> dtoEntityList = new ArrayList<>();
        ModeloAvionDTO dtoEntity =  null;
		for(ModeloAvion jpaEntity: jpaEntityList){
			dtoEntity =  new ModeloAvionDTO();
            dtoEntity.setIdModeloAvion( jpaEntity.getIdModeloAvion() );
            dtoEntity.setModelo( jpaEntity.getModelo() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
            //Not Embedable: TipoCabina -> Parametros, FTable: parametros, HyperName:null
            dtoEntity.setTipoCabina( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
            //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
            dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
            //Not Embedable: IdFabricante -> Parametros, FTable: parametros, HyperName:null
            dtoEntity.setIdFabricante( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
            dtoEntity.setEstaus( jpaEntity.getEstaus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
