package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.TipoProveedor;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table tipo_proveedor.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class TipoProveedorAssembler {    
    
    /** 
     * Private Constructor
     */
    private TipoProveedorAssembler() {
    }

    public static TipoProveedor buildJpaEntity(TipoProveedorDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		TipoProveedor jpaEntity = new TipoProveedor();

        jpaEntity.setIdTipoProveedor( dtoEntity.getIdTipoProveedor()); // normal
        jpaEntity.setNombreEs( dtoEntity.getNombreEs()); // normal
        jpaEntity.setNombreEn( dtoEntity.getNombreEn()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<TipoProveedor> buildJpaEntityList(List<TipoProveedorDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<TipoProveedor> jpaEntityList = new ArrayList<>();
		TipoProveedor jpaEntity = null;
		for(TipoProveedorDTO dtoEntity: dtoEntityList){
			jpaEntity = new TipoProveedor();
            jpaEntity.setIdTipoProveedor( dtoEntity.getIdTipoProveedor());
            jpaEntity.setNombreEs( dtoEntity.getNombreEs());
            jpaEntity.setNombreEn( dtoEntity.getNombreEn());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static TipoProveedorDTO buildDTOEntity(TipoProveedor jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        TipoProveedorDTO dtoEntity =  new TipoProveedorDTO();		

        dtoEntity.setIdTipoProveedor( jpaEntity.getIdTipoProveedor() ); // primitive
        dtoEntity.setNombreEs( jpaEntity.getNombreEs() ); // primitive
        dtoEntity.setNombreEn( jpaEntity.getNombreEn() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<TipoProveedorDTO> buildDTOEntityList(List<TipoProveedor> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<TipoProveedorDTO> dtoEntityList = new ArrayList<>();
        TipoProveedorDTO dtoEntity =  null;
		for(TipoProveedor jpaEntity: jpaEntityList){
			dtoEntity =  new TipoProveedorDTO();
            dtoEntity.setIdTipoProveedor( jpaEntity.getIdTipoProveedor() );
            dtoEntity.setNombreEs( jpaEntity.getNombreEs() );
            dtoEntity.setNombreEn( jpaEntity.getNombreEn() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
