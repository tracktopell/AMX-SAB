package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Estacion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class EstacionAssembler {    
    
    /** 
     * Private Constructor
     */
    private EstacionAssembler() {
    }

    public static Estacion buildJpaEntity(EstacionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Estacion jpaEntity = new Estacion();

        jpaEntity.setIdEstacion( dtoEntity.getIdEstacion()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setClaveIata( dtoEntity.getClaveIata()); // normal
        CiudadDTO ciudadDTO = new CiudadDTO();
        ciudadDTO.setIdCiudad( dtoEntity.getIdCiudad());
        jpaEntity.setCiudad( CiudadAssembler.buildJpaEntity( ciudadDTO ));
        jpaEntity.setObservaciones( dtoEntity.getObservaciones()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Estacion> buildJpaEntityList(List<EstacionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Estacion> jpaEntityList = new ArrayList<>();
		Estacion jpaEntity = null;
		for(EstacionDTO dtoEntity: dtoEntityList){
			jpaEntity = new Estacion();
            jpaEntity.setIdEstacion( dtoEntity.getIdEstacion());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setClaveIata( dtoEntity.getClaveIata());
            CiudadDTO ciudadDTO = new CiudadDTO();
            ciudadDTO.setIdCiudad( dtoEntity.getIdCiudad());
            jpaEntity.setCiudad( CiudadAssembler.buildJpaEntity( ciudadDTO ));
            jpaEntity.setObservaciones( dtoEntity.getObservaciones());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static EstacionDTO buildDTOEntity(Estacion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        EstacionDTO dtoEntity =  new EstacionDTO();		

        dtoEntity.setIdEstacion( jpaEntity.getIdEstacion() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setClaveIata( jpaEntity.getClaveIata() ); // primitive
        //Not Embedable: IdCiudad -> Ciudad, FTable: ciudad, HyperName:ciudad
        dtoEntity.setIdCiudad( jpaEntity.getCiudad()!=null?jpaEntity.getCiudad().getIdCiudad():null);
        dtoEntity.setObservaciones( jpaEntity.getObservaciones() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<EstacionDTO> buildDTOEntityList(List<Estacion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<EstacionDTO> dtoEntityList = new ArrayList<>();
        EstacionDTO dtoEntity =  null;
		for(Estacion jpaEntity: jpaEntityList){
			dtoEntity =  new EstacionDTO();
            dtoEntity.setIdEstacion( jpaEntity.getIdEstacion() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setClaveIata( jpaEntity.getClaveIata() );
            //Not Embedable: IdCiudad -> Ciudad, FTable: ciudad, HyperName:ciudad
            dtoEntity.setIdCiudad( jpaEntity.getCiudad()!=null?jpaEntity.getCiudad().getIdCiudad():null);
            dtoEntity.setObservaciones( jpaEntity.getObservaciones() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
