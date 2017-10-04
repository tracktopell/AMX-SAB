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
 * @date 2017/10/04 07:27
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
        ParametrosDTO tipoCodigoServicioDTO = new ParametrosDTO();
        tipoCodigoServicioDTO.setIdParametro( dtoEntity.getTipoCodigoServicio());
        jpaEntity.setTipoCodigoServicio( ParametrosAssembler.buildJpaEntity( tipoCodigoServicioDTO ));

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
            ParametrosDTO tipoCodigoServicioDTO = new ParametrosDTO();
            tipoCodigoServicioDTO.setIdParametro( dtoEntity.getTipoCodigoServicio());
            jpaEntity.setTipoCodigoServicio( ParametrosAssembler.buildJpaEntity( tipoCodigoServicioDTO ));
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
        //Not Embedable: TipoCodigoServicio -> Parametros, FTable: parametros, HyperName:TIPO_CODIGO_SERVICIO
        dtoEntity.setTipoCodigoServicio( jpaEntity.getTipoCodigoServicio()!=null?jpaEntity.getTipoCodigoServicio().getIdParametro():null);

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
            //Not Embedable: TipoCodigoServicio -> Parametros, FTable: parametros, HyperName:TIPO_CODIGO_SERVICIO
            dtoEntity.setTipoCodigoServicio( jpaEntity.getTipoCodigoServicio()!=null?jpaEntity.getTipoCodigoServicio().getIdParametro():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
