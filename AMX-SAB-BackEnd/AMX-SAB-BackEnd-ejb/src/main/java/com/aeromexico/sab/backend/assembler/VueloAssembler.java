package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Vuelo;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table vuelo.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/27 07:01
 */

public class VueloAssembler {    
    
    /** 
     * Private Constructor
     */
    private VueloAssembler() {
    }

    public static Vuelo buildJpaEntity(VueloDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Vuelo jpaEntity = new Vuelo();

        jpaEntity.setIdVuelo( dtoEntity.getIdVuelo()); // normal
        jpaEntity.setNumeroVuelo( dtoEntity.getNumeroVuelo()); // normal
        // Assembler delegation: fTable.pk=id_parametro
        ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
        dtoParametrosDTO.setIdParametro( dtoEntity.getTipoVuelo());
        jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
        EstacionDTO estacionOrigenDTO = new EstacionDTO();
        estacionOrigenDTO.setIdEstacion( dtoEntity.getIdEstacionOrigen());
        jpaEntity.setEstacionOrigen( EstacionAssembler.buildJpaEntity( estacionOrigenDTO ));
        EstacionDTO estacionDestinoDTO = new EstacionDTO();
        estacionDestinoDTO.setIdEstacion( dtoEntity.getIdEstacionDestino());
        jpaEntity.setEstacionDestino( EstacionAssembler.buildJpaEntity( estacionDestinoDTO ));
        // Assembler delegation: fTable.pk=id_parametro
        ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
        dtoParametrosDTO.setIdParametro( dtoEntity.getTipoCabina());
        jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
        CompaniaDTO companiaDTO = new CompaniaDTO();
        companiaDTO.setIdCompania( dtoEntity.getIdCompania());
        jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
        ClaseDTO claseDTO = new ClaseDTO();
        claseDTO.setIdClase( dtoEntity.getIdClase());
        jpaEntity.setClase( ClaseAssembler.buildJpaEntity( claseDTO ));
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Vuelo> buildJpaEntityList(List<VueloDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Vuelo> jpaEntityList = new ArrayList<>();
		Vuelo jpaEntity = null;
		for(VueloDTO dtoEntity: dtoEntityList){
			jpaEntity = new Vuelo();
            jpaEntity.setIdVuelo( dtoEntity.getIdVuelo());
            jpaEntity.setNumeroVuelo( dtoEntity.getNumeroVuelo());
            // Assembler delegation: fTable.pk=id_parametro
            ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
            dtoParametrosDTO.setIdParametro( dtoEntity.getTipoVuelo());
            jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
            EstacionDTO estacionOrigenDTO = new EstacionDTO();
            estacionOrigenDTO.setIdEstacion( dtoEntity.getIdEstacionOrigen());
            jpaEntity.setEstacionOrigen( EstacionAssembler.buildJpaEntity( estacionOrigenDTO ));
            EstacionDTO estacionDestinoDTO = new EstacionDTO();
            estacionDestinoDTO.setIdEstacion( dtoEntity.getIdEstacionDestino());
            jpaEntity.setEstacionDestino( EstacionAssembler.buildJpaEntity( estacionDestinoDTO ));
            // Assembler delegation: fTable.pk=id_parametro
            ParametrosDTO dtoParametrosDTO = new ParametrosDTO();
            dtoParametrosDTO.setIdParametro( dtoEntity.getTipoCabina());
            jpaEntity.setParametros( ParametrosAssembler.buildJpaEntity( dtoParametrosDTO )); 
            CompaniaDTO companiaDTO = new CompaniaDTO();
            companiaDTO.setIdCompania( dtoEntity.getIdCompania());
            jpaEntity.setCompania( CompaniaAssembler.buildJpaEntity( companiaDTO ));
            ClaseDTO claseDTO = new ClaseDTO();
            claseDTO.setIdClase( dtoEntity.getIdClase());
            jpaEntity.setClase( ClaseAssembler.buildJpaEntity( claseDTO ));
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static VueloDTO buildDTOEntity(Vuelo jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        VueloDTO dtoEntity =  new VueloDTO();		

        dtoEntity.setIdVuelo( jpaEntity.getIdVuelo() ); // primitive
        dtoEntity.setNumeroVuelo( jpaEntity.getNumeroVuelo() ); // primitive
        //Not Embedable: TipoVuelo -> Parametros, FTable: parametros, HyperName:null
        dtoEntity.setTipoVuelo( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
        //Not Embedable: IdEstacionOrigen -> Estacion, FTable: estacion, HyperName:estacion_ORIGEN
        dtoEntity.setIdEstacionOrigen( jpaEntity.getEstacionOrigen()!=null?jpaEntity.getEstacionOrigen().getIdEstacion():null);
        //Not Embedable: IdEstacionDestino -> Estacion, FTable: estacion, HyperName:estacion_DESTINO
        dtoEntity.setIdEstacionDestino( jpaEntity.getEstacionDestino()!=null?jpaEntity.getEstacionDestino().getIdEstacion():null);
        //Not Embedable: TipoCabina -> Parametros, FTable: parametros, HyperName:null
        dtoEntity.setTipoCabina( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
        //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
        dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
        //Not Embedable: IdClase -> Clase, FTable: clase, HyperName:clase
        dtoEntity.setIdClase( jpaEntity.getClase()!=null?jpaEntity.getClase().getIdClase():null);
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<VueloDTO> buildDTOEntityList(List<Vuelo> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<VueloDTO> dtoEntityList = new ArrayList<>();
        VueloDTO dtoEntity =  null;
		for(Vuelo jpaEntity: jpaEntityList){
			dtoEntity =  new VueloDTO();
            dtoEntity.setIdVuelo( jpaEntity.getIdVuelo() );
            dtoEntity.setNumeroVuelo( jpaEntity.getNumeroVuelo() );
            //Not Embedable: TipoVuelo -> Parametros, FTable: parametros, HyperName:null
            dtoEntity.setTipoVuelo( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
            //Not Embedable: IdEstacionOrigen -> Estacion, FTable: estacion, HyperName:estacion_ORIGEN
            dtoEntity.setIdEstacionOrigen( jpaEntity.getEstacionOrigen()!=null?jpaEntity.getEstacionOrigen().getIdEstacion():null);
            //Not Embedable: IdEstacionDestino -> Estacion, FTable: estacion, HyperName:estacion_DESTINO
            dtoEntity.setIdEstacionDestino( jpaEntity.getEstacionDestino()!=null?jpaEntity.getEstacionDestino().getIdEstacion():null);
            //Not Embedable: TipoCabina -> Parametros, FTable: parametros, HyperName:null
            dtoEntity.setTipoCabina( jpaEntity.getParametros()!=null?jpaEntity.getParametros().getIdParametro():null);
            //Not Embedable: IdCompania -> Compania, FTable: compania, HyperName:compania
            dtoEntity.setIdCompania( jpaEntity.getCompania()!=null?jpaEntity.getCompania().getIdCompania():null);
            //Not Embedable: IdClase -> Clase, FTable: clase, HyperName:clase
            dtoEntity.setIdClase( jpaEntity.getClase()!=null?jpaEntity.getClase().getIdClase():null);
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
