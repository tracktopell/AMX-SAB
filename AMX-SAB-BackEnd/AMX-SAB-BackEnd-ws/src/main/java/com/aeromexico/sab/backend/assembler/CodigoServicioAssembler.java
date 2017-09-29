package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.CodigoServicio;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table codigo_servicio.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/28 19:09
 */

public class CodigoServicioAssembler {    
    
    /** 
     * Private Constructor
     */
    private CodigoServicioAssembler() {
    }

    public static CodigoServicio buildJpaEntity(CodigoServicioDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		CodigoServicio jpaEntity = new CodigoServicio();

        jpaEntity.setIdCodigoServicio( dtoEntity.getIdCodigoServicio()); // normal
        jpaEntity.setCveCodigoServicio( dtoEntity.getCveCodigoServicio()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal
        // Assembler delegation: fTable.pk=id_parametro
        ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
        dtoParametrosDTO.setIdParametro( dtoEntity.getTipoCodigoServicio());
        jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 

        return jpaEntity;
    }

    public static List<CodigoServicio> buildJpaEntityList(List<CodigoServicioDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<CodigoServicio> jpaEntityList = new ArrayList<>();
		CodigoServicio jpaEntity = null;
		for(CodigoServicioDTO dtoEntity: dtoEntityList){
			jpaEntity = new CodigoServicio();
            jpaEntity.setIdCodigoServicio( dtoEntity.getIdCodigoServicio());
            jpaEntity.setCveCodigoServicio( dtoEntity.getCveCodigoServicio());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
            // Assembler delegation: fTable.pk=id_parametro
            ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
            dtoParametrosDTO.setIdParametro( dtoEntity.getTipoCodigoServicio());
            jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static CodigoServicioDTO buildDTOEntity(CodigoServicio jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        CodigoServicioDTO dtoEntity =  new CodigoServicioDTO();		

        dtoEntity.setIdCodigoServicio( jpaEntity.getIdCodigoServicio() ); // primitive
        dtoEntity.setCveCodigoServicio( jpaEntity.getCveCodigoServicio() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive
        //Not Embedable: TipoCodigoServicio -> Parametros, FTable: parametros, HyperName:null
        dtoEntity.setTipoCodigoServicio( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);

        return dtoEntity;
    }

	public static List<CodigoServicioDTO> buildDTOEntityList(List<CodigoServicio> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<CodigoServicioDTO> dtoEntityList = new ArrayList<>();
        CodigoServicioDTO dtoEntity =  null;
		for(CodigoServicio jpaEntity: jpaEntityList){
			dtoEntity =  new CodigoServicioDTO();
            dtoEntity.setIdCodigoServicio( jpaEntity.getIdCodigoServicio() );
            dtoEntity.setCveCodigoServicio( jpaEntity.getCveCodigoServicio() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
            //Not Embedable: TipoCodigoServicio -> Parametros, FTable: parametros, HyperName:null
            dtoEntity.setTipoCodigoServicio( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
