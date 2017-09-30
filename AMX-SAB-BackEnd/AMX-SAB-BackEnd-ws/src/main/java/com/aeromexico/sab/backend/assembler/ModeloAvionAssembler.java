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
 * @date 2017/09/30 07:39
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
        ParametrosDTO tipoCabinaDTO = new ParametrosDTO();
        tipoCabinaDTO.setIdParametro( dtoEntity.getTipoCabina());
        jpaEntity.setTipoCabina( ParametrosAssembler.buildJpaEntity( tipoCabinaDTO ));
        CompaniaDTO companiaDTO = new CompaniaDTO();
        companiaDTO.setIdCompania( dtoEntity.getIdCompania());
        jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
        ParametrosDTO idFabricanteDTO = new ParametrosDTO();
        idFabricanteDTO.setIdParametro( dtoEntity.getIdFabricante());
        jpaEntity.setIdFabricante( ParametrosAssembler.buildJpaEntity( idFabricanteDTO ));
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
            ParametrosDTO tipoCabinaDTO = new ParametrosDTO();
            tipoCabinaDTO.setIdParametro( dtoEntity.getTipoCabina());
            jpaEntity.setTipoCabina( ParametrosAssembler.buildJpaEntity( tipoCabinaDTO ));
            CompaniaDTO companiaDTO = new CompaniaDTO();
            companiaDTO.setIdCompania( dtoEntity.getIdCompania());
            jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
            ParametrosDTO idFabricanteDTO = new ParametrosDTO();
            idFabricanteDTO.setIdParametro( dtoEntity.getIdFabricante());
            jpaEntity.setIdFabricante( ParametrosAssembler.buildJpaEntity( idFabricanteDTO ));
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
        //Not Embedable: TipoCabina -> Parametros, FTable: parametros, HyperName:TIPO_CABINA
        dtoEntity.setTipoCabina( jpaEntity.getTipoCabina()!=null?jpaEntity.getTipoCabina().getIdParametro():null);
        //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
        dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
        //Not Embedable: IdFabricante -> Parametros, FTable: parametros, HyperName:ID_FABRICANTE
        dtoEntity.setIdFabricante( jpaEntity.getIdFabricante()!=null?jpaEntity.getIdFabricante().getIdParametro():null);
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
            //Not Embedable: TipoCabina -> Parametros, FTable: parametros, HyperName:TIPO_CABINA
            dtoEntity.setTipoCabina( jpaEntity.getTipoCabina()!=null?jpaEntity.getTipoCabina().getIdParametro():null);
            //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
            dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
            //Not Embedable: IdFabricante -> Parametros, FTable: parametros, HyperName:ID_FABRICANTE
            dtoEntity.setIdFabricante( jpaEntity.getIdFabricante()!=null?jpaEntity.getIdFabricante().getIdParametro():null);
            dtoEntity.setEstaus( jpaEntity.getEstaus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
