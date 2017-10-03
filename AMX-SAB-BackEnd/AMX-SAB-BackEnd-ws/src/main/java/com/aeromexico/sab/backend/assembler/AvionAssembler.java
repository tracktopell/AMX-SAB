package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Avion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/03 13:52
 */

public class AvionAssembler {    
    
    /** 
     * Private Constructor
     */
    private AvionAssembler() {
    }

    public static Avion buildJpaEntity(AvionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Avion jpaEntity = new Avion();

        jpaEntity.setIdAvion( dtoEntity.getIdAvion()); // normal
        TipoEquipoAvionDTO tipoEquipoAvionDTO = new TipoEquipoAvionDTO();
        tipoEquipoAvionDTO.setIdTipoEquipoAvion( dtoEntity.getIdTipoEquipoAvion());
        jpaEntity.setTipoEquipoAvion( TipoEquipoAvionAssembler.buildJpaEntity( tipoEquipoAvionDTO ));
        jpaEntity.setMatricula( dtoEntity.getMatricula()); // normal
        jpaEntity.setMatriculaCorta( dtoEntity.getMatriculaCorta()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal
        ParametrosDTO idConectividadDTO = new ParametrosDTO();
        idConectividadDTO.setIdParametro( dtoEntity.getIdConectividad());
        jpaEntity.setIdConectividad( ParametrosAssembler.buildJpaEntity( idConectividadDTO ));

        return jpaEntity;
    }

    public static List<Avion> buildJpaEntityList(List<AvionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Avion> jpaEntityList = new ArrayList<>();
		Avion jpaEntity = null;
		for(AvionDTO dtoEntity: dtoEntityList){
			jpaEntity = new Avion();
            jpaEntity.setIdAvion( dtoEntity.getIdAvion());
            TipoEquipoAvionDTO tipoEquipoAvionDTO = new TipoEquipoAvionDTO();
            tipoEquipoAvionDTO.setIdTipoEquipoAvion( dtoEntity.getIdTipoEquipoAvion());
            jpaEntity.setTipoEquipoAvion( TipoEquipoAvionAssembler.buildJpaEntity( tipoEquipoAvionDTO ));
            jpaEntity.setMatricula( dtoEntity.getMatricula());
            jpaEntity.setMatriculaCorta( dtoEntity.getMatriculaCorta());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
            ParametrosDTO idConectividadDTO = new ParametrosDTO();
            idConectividadDTO.setIdParametro( dtoEntity.getIdConectividad());
            jpaEntity.setIdConectividad( ParametrosAssembler.buildJpaEntity( idConectividadDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static AvionDTO buildDTOEntity(Avion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        AvionDTO dtoEntity =  new AvionDTO();		

        dtoEntity.setIdAvion( jpaEntity.getIdAvion() ); // primitive
        //Not Embedable: IdTipoEquipoAvion -> TipoEquipoAvion, FTable: tipo_equipo_avion, HyperName:tipo_equipo_avion
        dtoEntity.setIdTipoEquipoAvion( jpaEntity.getTipoEquipoAvion()!=null?jpaEntity.getTipoEquipoAvion().getIdTipoEquipoAvion():null);
        dtoEntity.setMatricula( jpaEntity.getMatricula() ); // primitive
        dtoEntity.setMatriculaCorta( jpaEntity.getMatriculaCorta() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive
        //Not Embedable: IdConectividad -> Parametros, FTable: parametros, HyperName:ID_CONECTIVIDAD
        dtoEntity.setIdConectividad( jpaEntity.getIdConectividad()!=null?jpaEntity.getIdConectividad().getIdParametro():null);

        return dtoEntity;
    }

	public static List<AvionDTO> buildDTOEntityList(List<Avion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<AvionDTO> dtoEntityList = new ArrayList<>();
        AvionDTO dtoEntity =  null;
		for(Avion jpaEntity: jpaEntityList){
			dtoEntity =  new AvionDTO();
            dtoEntity.setIdAvion( jpaEntity.getIdAvion() );
            //Not Embedable: IdTipoEquipoAvion -> TipoEquipoAvion, FTable: tipo_equipo_avion, HyperName:tipo_equipo_avion
            dtoEntity.setIdTipoEquipoAvion( jpaEntity.getTipoEquipoAvion()!=null?jpaEntity.getTipoEquipoAvion().getIdTipoEquipoAvion():null);
            dtoEntity.setMatricula( jpaEntity.getMatricula() );
            dtoEntity.setMatriculaCorta( jpaEntity.getMatriculaCorta() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
            //Not Embedable: IdConectividad -> Parametros, FTable: parametros, HyperName:ID_CONECTIVIDAD
            dtoEntity.setIdConectividad( jpaEntity.getIdConectividad()!=null?jpaEntity.getIdConectividad().getIdParametro():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
