package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.MaterialMaster;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table material_master.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class MaterialMasterAssembler {    
    
    /** 
     * Private Constructor
     */
    private MaterialMasterAssembler() {
    }

    public static MaterialMaster buildJpaEntity(MaterialMasterDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		MaterialMaster jpaEntity = new MaterialMaster();

        // MaterialMasterPK is Embeddable. Begin nested settings
        jpaEntity.getMaterialMasterPK().setLnumeroParte( dtoEntity.getLnumeroParte() );  // nested FKs > BUG
        jpaEntity.getMaterialMasterPK().setIdKit( dtoEntity.getIdKit() );  // nested FKs > BUG
        // End nested settings
        jpaEntity.setCantidad( dtoEntity.getCantidad()); // normal
        jpaEntity.setPeso( dtoEntity.getPeso()); // normal
        // Assembler delegation: fTable.pk=id_parametro
        ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
        dtoParametrosDTO.setIdParametro( dtoEntity.getIdUnidadMedida());
        jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
        jpaEntity.setObservaciones( dtoEntity.getObservaciones()); // normal
        MaterialDTO materiallDTO = new MaterialDTO();
        materiallDTO.setNumeroParte( dtoEntity.getLnumeroParte());
        jpaEntity.setMateriall( MaterialAssembler.buildJpaEntity( materiallDTO ));
        MasterDTO masterDTO = new MasterDTO();
        masterDTO.setIdKit( dtoEntity.getIdKit());
        jpaEntity.setMaster( MasterAssembler.buildJpaEntity( masterDTO ));

        return jpaEntity;
    }

    public static List<MaterialMaster> buildJpaEntityList(List<MaterialMasterDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<MaterialMaster> jpaEntityList = new ArrayList<>();
		MaterialMaster jpaEntity = null;
		for(MaterialMasterDTO dtoEntity: dtoEntityList){
			jpaEntity = new MaterialMaster();
            // MaterialMasterPK is Embeddable. Begin nested settings
            jpaEntity.getMaterialMasterPK().setLnumeroParte( dtoEntity.getLnumeroParte() );  // nested FKs > BUG
            jpaEntity.getMaterialMasterPK().setIdKit( dtoEntity.getIdKit() );  // nested FKs > BUG
            // End nested settings
            jpaEntity.setCantidad( dtoEntity.getCantidad());
            jpaEntity.setPeso( dtoEntity.getPeso());
            // Assembler delegation: fTable.pk=id_parametro
            ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
            dtoParametrosDTO.setIdParametro( dtoEntity.getIdUnidadMedida());
            jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
            jpaEntity.setObservaciones( dtoEntity.getObservaciones());
            MaterialDTO materiallDTO = new MaterialDTO();
            materiallDTO.setNumeroParte( dtoEntity.getLnumeroParte());
            jpaEntity.setMateriall( MaterialAssembler.buildJpaEntity( materiallDTO ));
            MasterDTO masterDTO = new MasterDTO();
            masterDTO.setIdKit( dtoEntity.getIdKit());
            jpaEntity.setMaster( MasterAssembler.buildJpaEntity( masterDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static MaterialMasterDTO buildDTOEntity(MaterialMaster jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        MaterialMasterDTO dtoEntity =  new MaterialMasterDTO();		

        // Embedable: MaterialMasterPK, begin nested settings
        dtoEntity.setLnumeroParte( jpaEntity.getMaterialMasterPK().getLnumeroParte() ); // bug 3 ?
        dtoEntity.setIdKit( jpaEntity.getMaterialMasterPK().getIdKit() ); // bug 3 ?
        // End nested settings
        dtoEntity.setCantidad( jpaEntity.getCantidad() ); // primitive
        dtoEntity.setPeso( jpaEntity.getPeso() ); // primitive
        //Not Embedable: IdUnidadMedida -> Parametros, FTable: parametros, HyperName:null
        dtoEntity.setIdUnidadMedida( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
        dtoEntity.setObservaciones( jpaEntity.getObservaciones() ); // primitive
        //Not Embedable: LnumeroParte -> Material, FTable: material, HyperName:materialL
        dtoEntity.setLnumeroParte( jpaEntity.getMateriall()!=null?jpaEntity.getMateriall().getNumeroParte():null);
        //Not Embedable: IdKit -> Master, FTable: master, HyperName:master
        dtoEntity.setIdKit( jpaEntity.getMaster()!=null?jpaEntity.getMaster().getIdKit():null);

        return dtoEntity;
    }

	public static List<MaterialMasterDTO> buildDTOEntityList(List<MaterialMaster> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<MaterialMasterDTO> dtoEntityList = new ArrayList<>();
        MaterialMasterDTO dtoEntity =  null;
		for(MaterialMaster jpaEntity: jpaEntityList){
			dtoEntity =  new MaterialMasterDTO();
            // Embedable: MaterialMasterPK, begin nested settings
            dtoEntity.setLnumeroParte( jpaEntity.getMaterialMasterPK().getLnumeroParte() );
            dtoEntity.setIdKit( jpaEntity.getMaterialMasterPK().getIdKit() );
            // End nested settings
            dtoEntity.setCantidad( jpaEntity.getCantidad() );
            dtoEntity.setPeso( jpaEntity.getPeso() );
            //Not Embedable: IdUnidadMedida -> Parametros, FTable: parametros, HyperName:null
            dtoEntity.setIdUnidadMedida( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
            dtoEntity.setObservaciones( jpaEntity.getObservaciones() );
            //Not Embedable: LnumeroParte -> Material, FTable: material, HyperName:materialL
            dtoEntity.setLnumeroParte( jpaEntity.getMateriall()!=null?jpaEntity.getMateriall().getNumeroParte():null);
            //Not Embedable: IdKit -> Master, FTable: master, HyperName:master
            dtoEntity.setIdKit( jpaEntity.getMaster()!=null?jpaEntity.getMaster().getIdKit():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
