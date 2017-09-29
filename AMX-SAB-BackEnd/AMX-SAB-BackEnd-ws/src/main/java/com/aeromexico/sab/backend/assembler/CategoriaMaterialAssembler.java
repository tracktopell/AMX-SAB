package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.CategoriaMaterial;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table categoria_material.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class CategoriaMaterialAssembler {    
    
    /** 
     * Private Constructor
     */
    private CategoriaMaterialAssembler() {
    }

    public static CategoriaMaterial buildJpaEntity(CategoriaMaterialDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		CategoriaMaterial jpaEntity = new CategoriaMaterial();

        jpaEntity.setIdCategoriaMaterial( dtoEntity.getIdCategoriaMaterial()); // normal
        jpaEntity.setNombreEs( dtoEntity.getNombreEs()); // normal
        jpaEntity.setNombreEn( dtoEntity.getNombreEn()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<CategoriaMaterial> buildJpaEntityList(List<CategoriaMaterialDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<CategoriaMaterial> jpaEntityList = new ArrayList<>();
		CategoriaMaterial jpaEntity = null;
		for(CategoriaMaterialDTO dtoEntity: dtoEntityList){
			jpaEntity = new CategoriaMaterial();
            jpaEntity.setIdCategoriaMaterial( dtoEntity.getIdCategoriaMaterial());
            jpaEntity.setNombreEs( dtoEntity.getNombreEs());
            jpaEntity.setNombreEn( dtoEntity.getNombreEn());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static CategoriaMaterialDTO buildDTOEntity(CategoriaMaterial jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        CategoriaMaterialDTO dtoEntity =  new CategoriaMaterialDTO();		

        dtoEntity.setIdCategoriaMaterial( jpaEntity.getIdCategoriaMaterial() ); // primitive
        dtoEntity.setNombreEs( jpaEntity.getNombreEs() ); // primitive
        dtoEntity.setNombreEn( jpaEntity.getNombreEn() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<CategoriaMaterialDTO> buildDTOEntityList(List<CategoriaMaterial> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<CategoriaMaterialDTO> dtoEntityList = new ArrayList<>();
        CategoriaMaterialDTO dtoEntity =  null;
		for(CategoriaMaterial jpaEntity: jpaEntityList){
			dtoEntity =  new CategoriaMaterialDTO();
            dtoEntity.setIdCategoriaMaterial( jpaEntity.getIdCategoriaMaterial() );
            dtoEntity.setNombreEs( jpaEntity.getNombreEs() );
            dtoEntity.setNombreEn( jpaEntity.getNombreEn() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
