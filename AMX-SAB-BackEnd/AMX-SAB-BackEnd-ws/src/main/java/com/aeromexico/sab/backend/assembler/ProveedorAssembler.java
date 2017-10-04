package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Proveedor;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table proveedor.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/04 07:27
 */

public class ProveedorAssembler {    
    
    /** 
     * Private Constructor
     */
    private ProveedorAssembler() {
    }

    public static Proveedor buildJpaEntity(ProveedorDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Proveedor jpaEntity = new Proveedor();

        jpaEntity.setIdProveedor( dtoEntity.getIdProveedor()); // normal
        TipoProveedorDTO tipoProveedorDTO = new TipoProveedorDTO();
        tipoProveedorDTO.setIdTipoProveedor( dtoEntity.getIdTipoProveedor());
        jpaEntity.setTipoProveedor( TipoProveedorAssembler.buildJpaEntity( tipoProveedorDTO ));
        jpaEntity.setIdEstacion( dtoEntity.getIdEstacion()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setCveProveedor( dtoEntity.getCveProveedor()); // normal
        jpaEntity.setRazonSocial( dtoEntity.getRazonSocial()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Proveedor> buildJpaEntityList(List<ProveedorDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Proveedor> jpaEntityList = new ArrayList<>();
		Proveedor jpaEntity = null;
		for(ProveedorDTO dtoEntity: dtoEntityList){
			jpaEntity = new Proveedor();
            jpaEntity.setIdProveedor( dtoEntity.getIdProveedor());
            TipoProveedorDTO tipoProveedorDTO = new TipoProveedorDTO();
            tipoProveedorDTO.setIdTipoProveedor( dtoEntity.getIdTipoProveedor());
            jpaEntity.setTipoProveedor( TipoProveedorAssembler.buildJpaEntity( tipoProveedorDTO ));
            jpaEntity.setIdEstacion( dtoEntity.getIdEstacion());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setCveProveedor( dtoEntity.getCveProveedor());
            jpaEntity.setRazonSocial( dtoEntity.getRazonSocial());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ProveedorDTO buildDTOEntity(Proveedor jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ProveedorDTO dtoEntity =  new ProveedorDTO();		

        dtoEntity.setIdProveedor( jpaEntity.getIdProveedor() ); // primitive
        //Not Embedable: IdTipoProveedor -> TipoProveedor, FTable: tipo_proveedor, HyperName:tipo_proveedor
        dtoEntity.setIdTipoProveedor( jpaEntity.getTipoProveedor()!=null?jpaEntity.getTipoProveedor().getIdTipoProveedor():null);
        dtoEntity.setIdEstacion( jpaEntity.getIdEstacion() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setCveProveedor( jpaEntity.getCveProveedor() ); // primitive
        dtoEntity.setRazonSocial( jpaEntity.getRazonSocial() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<ProveedorDTO> buildDTOEntityList(List<Proveedor> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ProveedorDTO> dtoEntityList = new ArrayList<>();
        ProveedorDTO dtoEntity =  null;
		for(Proveedor jpaEntity: jpaEntityList){
			dtoEntity =  new ProveedorDTO();
            dtoEntity.setIdProveedor( jpaEntity.getIdProveedor() );
            //Not Embedable: IdTipoProveedor -> TipoProveedor, FTable: tipo_proveedor, HyperName:tipo_proveedor
            dtoEntity.setIdTipoProveedor( jpaEntity.getTipoProveedor()!=null?jpaEntity.getTipoProveedor().getIdTipoProveedor():null);
            dtoEntity.setIdEstacion( jpaEntity.getIdEstacion() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setCveProveedor( jpaEntity.getCveProveedor() );
            dtoEntity.setRazonSocial( jpaEntity.getRazonSocial() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
