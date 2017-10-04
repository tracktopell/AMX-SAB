package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.AvionCapacidad;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table avion_capacidad.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/04 07:27
 */

public class AvionCapacidadAssembler {    
    
    /** 
     * Private Constructor
     */
    private AvionCapacidadAssembler() {
    }

    public static AvionCapacidad buildJpaEntity(AvionCapacidadDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		AvionCapacidad jpaEntity = new AvionCapacidad();

        jpaEntity.setIdAvionCapacidad( dtoEntity.getIdAvionCapacidad()); // normal
        AvionDTO avionDTO = new AvionDTO();
        avionDTO.setIdAvion( dtoEntity.getIdAvion());
        jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
        ClaseDTO claseDTO = new ClaseDTO();
        claseDTO.setIdClase( dtoEntity.getIdClase());
        jpaEntity.setClase( ClaseAssembler.buildJpaEntity( claseDTO ));
        jpaEntity.setCapacidad( dtoEntity.getCapacidad()); // normal

        return jpaEntity;
    }

    public static List<AvionCapacidad> buildJpaEntityList(List<AvionCapacidadDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<AvionCapacidad> jpaEntityList = new ArrayList<>();
		AvionCapacidad jpaEntity = null;
		for(AvionCapacidadDTO dtoEntity: dtoEntityList){
			jpaEntity = new AvionCapacidad();
            jpaEntity.setIdAvionCapacidad( dtoEntity.getIdAvionCapacidad());
            AvionDTO avionDTO = new AvionDTO();
            avionDTO.setIdAvion( dtoEntity.getIdAvion());
            jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
            ClaseDTO claseDTO = new ClaseDTO();
            claseDTO.setIdClase( dtoEntity.getIdClase());
            jpaEntity.setClase( ClaseAssembler.buildJpaEntity( claseDTO ));
            jpaEntity.setCapacidad( dtoEntity.getCapacidad());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static AvionCapacidadDTO buildDTOEntity(AvionCapacidad jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        AvionCapacidadDTO dtoEntity =  new AvionCapacidadDTO();		

        dtoEntity.setIdAvionCapacidad( jpaEntity.getIdAvionCapacidad() ); // primitive
        //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
        dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
        //Not Embedable: IdClase -> Clase, FTable: clase, HyperName:clase
        dtoEntity.setIdClase( jpaEntity.getClase()!=null?jpaEntity.getClase().getIdClase():null);
        dtoEntity.setCapacidad( jpaEntity.getCapacidad() ); // primitive

        return dtoEntity;
    }

	public static List<AvionCapacidadDTO> buildDTOEntityList(List<AvionCapacidad> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<AvionCapacidadDTO> dtoEntityList = new ArrayList<>();
        AvionCapacidadDTO dtoEntity =  null;
		for(AvionCapacidad jpaEntity: jpaEntityList){
			dtoEntity =  new AvionCapacidadDTO();
            dtoEntity.setIdAvionCapacidad( jpaEntity.getIdAvionCapacidad() );
            //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
            dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
            //Not Embedable: IdClase -> Clase, FTable: clase, HyperName:clase
            dtoEntity.setIdClase( jpaEntity.getClase()!=null?jpaEntity.getClase().getIdClase():null);
            dtoEntity.setCapacidad( jpaEntity.getCapacidad() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
