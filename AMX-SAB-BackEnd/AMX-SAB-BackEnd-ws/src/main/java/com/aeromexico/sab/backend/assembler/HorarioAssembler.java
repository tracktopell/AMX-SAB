package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Horario;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table horario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class HorarioAssembler {    
    
    /** 
     * Private Constructor
     */
    private HorarioAssembler() {
    }

    public static Horario buildJpaEntity(HorarioDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Horario jpaEntity = new Horario();

        jpaEntity.setIdHorario( dtoEntity.getIdHorario()); // normal
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setIdRegion( dtoEntity.getIdRegion());
        jpaEntity.setRegion( RegionAssembler.buildJpaEntity( regionDTO ));
        jpaEntity.setHoraInicio( dtoEntity.getHoraInicio()); // normal
        jpaEntity.setHoraFin( dtoEntity.getHoraFin()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Horario> buildJpaEntityList(List<HorarioDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Horario> jpaEntityList = new ArrayList<>();
		Horario jpaEntity = null;
		for(HorarioDTO dtoEntity: dtoEntityList){
			jpaEntity = new Horario();
            jpaEntity.setIdHorario( dtoEntity.getIdHorario());
            RegionDTO regionDTO = new RegionDTO();
            regionDTO.setIdRegion( dtoEntity.getIdRegion());
            jpaEntity.setRegion( RegionAssembler.buildJpaEntity( regionDTO ));
            jpaEntity.setHoraInicio( dtoEntity.getHoraInicio());
            jpaEntity.setHoraFin( dtoEntity.getHoraFin());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static HorarioDTO buildDTOEntity(Horario jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        HorarioDTO dtoEntity =  new HorarioDTO();		

        dtoEntity.setIdHorario( jpaEntity.getIdHorario() ); // primitive
        //Not Embedable: IdRegion -> Region, FTable: region, HyperName:region
        dtoEntity.setIdRegion( jpaEntity.getRegion()!=null?jpaEntity.getRegion().getIdRegion():null);
        dtoEntity.setHoraInicio( jpaEntity.getHoraInicio() ); // primitive
        dtoEntity.setHoraFin( jpaEntity.getHoraFin() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<HorarioDTO> buildDTOEntityList(List<Horario> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<HorarioDTO> dtoEntityList = new ArrayList<>();
        HorarioDTO dtoEntity =  null;
		for(Horario jpaEntity: jpaEntityList){
			dtoEntity =  new HorarioDTO();
            dtoEntity.setIdHorario( jpaEntity.getIdHorario() );
            //Not Embedable: IdRegion -> Region, FTable: region, HyperName:region
            dtoEntity.setIdRegion( jpaEntity.getRegion()!=null?jpaEntity.getRegion().getIdRegion():null);
            dtoEntity.setHoraInicio( jpaEntity.getHoraInicio() );
            dtoEntity.setHoraFin( jpaEntity.getHoraFin() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
