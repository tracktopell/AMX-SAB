package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.AvionAudifono;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table avion_audifono.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/03 13:52
 */

public class AvionAudifonoAssembler {    
    
    /** 
     * Private Constructor
     */
    private AvionAudifonoAssembler() {
    }

    public static AvionAudifono buildJpaEntity(AvionAudifonoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		AvionAudifono jpaEntity = new AvionAudifono();

        jpaEntity.setIdAvionAudifono( dtoEntity.getIdAvionAudifono()); // normal
        AvionDTO avionDTO = new AvionDTO();
        avionDTO.setIdAvion( dtoEntity.getIdAvion());
        jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
        ClaseDTO claseDTO = new ClaseDTO();
        claseDTO.setIdClase( dtoEntity.getIdClase());
        jpaEntity.setClase( ClaseAssembler.buildJpaEntity( claseDTO ));
        ParametrosDTO tipoAudifonoDTO = new ParametrosDTO();
        tipoAudifonoDTO.setIdParametro( dtoEntity.getTipoAudifono());
        jpaEntity.setTipoAudifono( ParametrosAssembler.buildJpaEntity( tipoAudifonoDTO ));

        return jpaEntity;
    }

    public static List<AvionAudifono> buildJpaEntityList(List<AvionAudifonoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<AvionAudifono> jpaEntityList = new ArrayList<>();
		AvionAudifono jpaEntity = null;
		for(AvionAudifonoDTO dtoEntity: dtoEntityList){
			jpaEntity = new AvionAudifono();
            jpaEntity.setIdAvionAudifono( dtoEntity.getIdAvionAudifono());
            AvionDTO avionDTO = new AvionDTO();
            avionDTO.setIdAvion( dtoEntity.getIdAvion());
            jpaEntity.setAvion( AvionAssembler.buildJpaEntity( avionDTO ));
            ClaseDTO claseDTO = new ClaseDTO();
            claseDTO.setIdClase( dtoEntity.getIdClase());
            jpaEntity.setClase( ClaseAssembler.buildJpaEntity( claseDTO ));
            ParametrosDTO tipoAudifonoDTO = new ParametrosDTO();
            tipoAudifonoDTO.setIdParametro( dtoEntity.getTipoAudifono());
            jpaEntity.setTipoAudifono( ParametrosAssembler.buildJpaEntity( tipoAudifonoDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static AvionAudifonoDTO buildDTOEntity(AvionAudifono jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        AvionAudifonoDTO dtoEntity =  new AvionAudifonoDTO();		

        dtoEntity.setIdAvionAudifono( jpaEntity.getIdAvionAudifono() ); // primitive
        //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
        dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
        //Not Embedable: IdClase -> Clase, FTable: clase, HyperName:clase
        dtoEntity.setIdClase( jpaEntity.getClase()!=null?jpaEntity.getClase().getIdClase():null);
        //Not Embedable: TipoAudifono -> Parametros, FTable: parametros, HyperName:TIPO_AUDIFONO
        dtoEntity.setTipoAudifono( jpaEntity.getTipoAudifono()!=null?jpaEntity.getTipoAudifono().getIdParametro():null);

        return dtoEntity;
    }

	public static List<AvionAudifonoDTO> buildDTOEntityList(List<AvionAudifono> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<AvionAudifonoDTO> dtoEntityList = new ArrayList<>();
        AvionAudifonoDTO dtoEntity =  null;
		for(AvionAudifono jpaEntity: jpaEntityList){
			dtoEntity =  new AvionAudifonoDTO();
            dtoEntity.setIdAvionAudifono( jpaEntity.getIdAvionAudifono() );
            //Not Embedable: IdAvion -> Avion, FTable: avion, HyperName:avion
            dtoEntity.setIdAvion( jpaEntity.getAvion()!=null?jpaEntity.getAvion().getIdAvion():null);
            //Not Embedable: IdClase -> Clase, FTable: clase, HyperName:clase
            dtoEntity.setIdClase( jpaEntity.getClase()!=null?jpaEntity.getClase().getIdClase():null);
            //Not Embedable: TipoAudifono -> Parametros, FTable: parametros, HyperName:TIPO_AUDIFONO
            dtoEntity.setTipoAudifono( jpaEntity.getTipoAudifono()!=null?jpaEntity.getTipoAudifono().getIdParametro():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
