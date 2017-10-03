package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.EquipamientoComisariato;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table equipamiento_comisariato.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/03 13:52
 */

public class EquipamientoComisariatoAssembler {    
    
    /** 
     * Private Constructor
     */
    private EquipamientoComisariatoAssembler() {
    }

    public static EquipamientoComisariato buildJpaEntity(EquipamientoComisariatoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		EquipamientoComisariato jpaEntity = new EquipamientoComisariato();

        jpaEntity.setIdEquipamientoComisariato( dtoEntity.getIdEquipamientoComisariato()); // normal
        AvionDTO avionDTO = new AvionDTO();
        avionDTO.setIdAvion( dtoEntity.getIdAvion());
        jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
        jpaEntity.setNombreEs( dtoEntity.getNombreEs()); // normal
        jpaEntity.setNombreEn( dtoEntity.getNombreEn()); // normal
        jpaEntity.setCantidad( dtoEntity.getCantidad()); // normal
        jpaEntity.setPeso( dtoEntity.getPeso()); // normal
        jpaEntity.setObservaciones( dtoEntity.getObservaciones()); // normal
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setNumeroParte( dtoEntity.getNumeroParte());
        jpaEntity.setMaterial( MaterialAssembler.buildJpaEntity( materialDTO ));
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<EquipamientoComisariato> buildJpaEntityList(List<EquipamientoComisariatoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<EquipamientoComisariato> jpaEntityList = new ArrayList<>();
		EquipamientoComisariato jpaEntity = null;
		for(EquipamientoComisariatoDTO dtoEntity: dtoEntityList){
			jpaEntity = new EquipamientoComisariato();
            jpaEntity.setIdEquipamientoComisariato( dtoEntity.getIdEquipamientoComisariato());
            AvionDTO avionDTO = new AvionDTO();
            avionDTO.setIdAvion( dtoEntity.getIdAvion());
            jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
            jpaEntity.setNombreEs( dtoEntity.getNombreEs());
            jpaEntity.setNombreEn( dtoEntity.getNombreEn());
            jpaEntity.setCantidad( dtoEntity.getCantidad());
            jpaEntity.setPeso( dtoEntity.getPeso());
            jpaEntity.setObservaciones( dtoEntity.getObservaciones());
            MaterialDTO materialDTO = new MaterialDTO();
            materialDTO.setNumeroParte( dtoEntity.getNumeroParte());
            jpaEntity.setMaterial( MaterialAssembler.buildJpaEntity( materialDTO ));
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static EquipamientoComisariatoDTO buildDTOEntity(EquipamientoComisariato jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        EquipamientoComisariatoDTO dtoEntity =  new EquipamientoComisariatoDTO();		

        dtoEntity.setIdEquipamientoComisariato( jpaEntity.getIdEquipamientoComisariato() ); // primitive
        //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
        dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
        dtoEntity.setNombreEs( jpaEntity.getNombreEs() ); // primitive
        dtoEntity.setNombreEn( jpaEntity.getNombreEn() ); // primitive
        dtoEntity.setCantidad( jpaEntity.getCantidad() ); // primitive
        dtoEntity.setPeso( jpaEntity.getPeso() ); // primitive
        dtoEntity.setObservaciones( jpaEntity.getObservaciones() ); // primitive
        //Not Embedable: NumeroParte -> Material, FTable: material, HyperName:material
        dtoEntity.setNumeroParte( jpaEntity.getMaterial()!=null?jpaEntity.getMaterial().getNumeroParte():null);
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<EquipamientoComisariatoDTO> buildDTOEntityList(List<EquipamientoComisariato> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<EquipamientoComisariatoDTO> dtoEntityList = new ArrayList<>();
        EquipamientoComisariatoDTO dtoEntity =  null;
		for(EquipamientoComisariato jpaEntity: jpaEntityList){
			dtoEntity =  new EquipamientoComisariatoDTO();
            dtoEntity.setIdEquipamientoComisariato( jpaEntity.getIdEquipamientoComisariato() );
            //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
            dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
            dtoEntity.setNombreEs( jpaEntity.getNombreEs() );
            dtoEntity.setNombreEn( jpaEntity.getNombreEn() );
            dtoEntity.setCantidad( jpaEntity.getCantidad() );
            dtoEntity.setPeso( jpaEntity.getPeso() );
            dtoEntity.setObservaciones( jpaEntity.getObservaciones() );
            //Not Embedable: NumeroParte -> Material, FTable: material, HyperName:material
            dtoEntity.setNumeroParte( jpaEntity.getMaterial()!=null?jpaEntity.getMaterial().getNumeroParte():null);
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
