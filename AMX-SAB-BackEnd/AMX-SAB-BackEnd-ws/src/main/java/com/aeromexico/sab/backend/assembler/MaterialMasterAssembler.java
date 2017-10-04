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
 * @date 2017/10/04 07:27
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
        jpaEntity.getMaterialMasterPK().setNumeroParte( dtoEntity.getNumeroParte() );  // nested FKs > BUG
        jpaEntity.getMaterialMasterPK().setIdKit( dtoEntity.getIdKit() );  // nested FKs > BUG
        // End nested settings
        jpaEntity.setCantidad( dtoEntity.getCantidad()); // normal
        jpaEntity.setPeso( dtoEntity.getPeso()); // normal
        ParametrosDTO idUnidadMedidaDTO = new ParametrosDTO();
        idUnidadMedidaDTO.setIdParametro( dtoEntity.getIdUnidadMedida());
        jpaEntity.setIdUnidadMedida( ParametrosAssembler.buildJpaEntity( idUnidadMedidaDTO ));
        jpaEntity.setObservaciones( dtoEntity.getObservaciones()); // normal
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setNumeroParte( dtoEntity.getNumeroParte());
        jpaEntity.setMaterial( MaterialAssembler.buildJpaEntity( materialDTO ));
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
            jpaEntity.getMaterialMasterPK().setNumeroParte( dtoEntity.getNumeroParte() );  // nested FKs > BUG
            jpaEntity.getMaterialMasterPK().setIdKit( dtoEntity.getIdKit() );  // nested FKs > BUG
            // End nested settings
            jpaEntity.setCantidad( dtoEntity.getCantidad());
            jpaEntity.setPeso( dtoEntity.getPeso());
            ParametrosDTO idUnidadMedidaDTO = new ParametrosDTO();
            idUnidadMedidaDTO.setIdParametro( dtoEntity.getIdUnidadMedida());
            jpaEntity.setIdUnidadMedida( ParametrosAssembler.buildJpaEntity( idUnidadMedidaDTO ));
            jpaEntity.setObservaciones( dtoEntity.getObservaciones());
            MaterialDTO materialDTO = new MaterialDTO();
            materialDTO.setNumeroParte( dtoEntity.getNumeroParte());
            jpaEntity.setMaterial( MaterialAssembler.buildJpaEntity( materialDTO ));
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
        dtoEntity.setNumeroParte( jpaEntity.getMaterialMasterPK().getNumeroParte() ); // bug 3 ?
        dtoEntity.setIdKit( jpaEntity.getMaterialMasterPK().getIdKit() ); // bug 3 ?
        // End nested settings
        dtoEntity.setCantidad( jpaEntity.getCantidad() ); // primitive
        dtoEntity.setPeso( jpaEntity.getPeso() ); // primitive
        //Not Embedable: IdUnidadMedida -> Parametros, FTable: parametros, HyperName:ID_UNIDAD_MEDIDA
        dtoEntity.setIdUnidadMedida( jpaEntity.getIdUnidadMedida()!=null?jpaEntity.getIdUnidadMedida().getIdParametro():null);
        dtoEntity.setObservaciones( jpaEntity.getObservaciones() ); // primitive
        //Not Embedable: NumeroParte -> Material, FTable: material, HyperName:material
        dtoEntity.setNumeroParte( jpaEntity.getMaterial()!=null?jpaEntity.getMaterial().getNumeroParte():null);
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
            dtoEntity.setNumeroParte( jpaEntity.getMaterialMasterPK().getNumeroParte() );
            dtoEntity.setIdKit( jpaEntity.getMaterialMasterPK().getIdKit() );
            // End nested settings
            dtoEntity.setCantidad( jpaEntity.getCantidad() );
            dtoEntity.setPeso( jpaEntity.getPeso() );
            //Not Embedable: IdUnidadMedida -> Parametros, FTable: parametros, HyperName:ID_UNIDAD_MEDIDA
            dtoEntity.setIdUnidadMedida( jpaEntity.getIdUnidadMedida()!=null?jpaEntity.getIdUnidadMedida().getIdParametro():null);
            dtoEntity.setObservaciones( jpaEntity.getObservaciones() );
            //Not Embedable: NumeroParte -> Material, FTable: material, HyperName:material
            dtoEntity.setNumeroParte( jpaEntity.getMaterial()!=null?jpaEntity.getMaterial().getNumeroParte():null);
            //Not Embedable: IdKit -> Master, FTable: master, HyperName:master
            dtoEntity.setIdKit( jpaEntity.getMaster()!=null?jpaEntity.getMaster().getIdKit():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
