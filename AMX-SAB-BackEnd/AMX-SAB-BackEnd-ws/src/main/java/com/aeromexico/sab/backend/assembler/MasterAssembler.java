package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Master;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table master.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/03 13:52
 */

public class MasterAssembler {    
    
    /** 
     * Private Constructor
     */
    private MasterAssembler() {
    }

    public static Master buildJpaEntity(MasterDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Master jpaEntity = new Master();

        jpaEntity.setIdKit( dtoEntity.getIdKit()); // normal
        jpaEntity.setNombreEs( dtoEntity.getNombreEs()); // normal
        jpaEntity.setNombreEn( dtoEntity.getNombreEn()); // normal
        jpaEntity.setUrlMultimedia( dtoEntity.getUrlMultimedia()); // normal
        jpaEntity.setContenedor( dtoEntity.getContenedor()); // normal
        ParametrosDTO idUnidadMedidaDTO = new ParametrosDTO();
        idUnidadMedidaDTO.setIdParametro( dtoEntity.getIdUnidadMedida());
        jpaEntity.setIdUnidadMedida( ParametrosAssembler.buildJpaEntity( idUnidadMedidaDTO ));
        ParametrosDTO idInstruccionesNacionalesDTO = new ParametrosDTO();
        idInstruccionesNacionalesDTO.setIdParametro( dtoEntity.getIdInstruccionesNacionales());
        jpaEntity.setIdInstruccionesNacionales( ParametrosAssembler.buildJpaEntity( idInstruccionesNacionalesDTO ));
        ParametrosDTO idInstruccionesInternacDTO = new ParametrosDTO();
        idInstruccionesInternacDTO.setIdParametro( dtoEntity.getIdInstruccionesInternac());
        jpaEntity.setIdInstruccionesInternac( ParametrosAssembler.buildJpaEntity( idInstruccionesInternacDTO ));
        ParametrosDTO idTipoKitDTO = new ParametrosDTO();
        idTipoKitDTO.setIdParametro( dtoEntity.getIdTipoKit());
        jpaEntity.setIdTipoKit( ParametrosAssembler.buildJpaEntity( idTipoKitDTO ));

        return jpaEntity;
    }

    public static List<Master> buildJpaEntityList(List<MasterDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Master> jpaEntityList = new ArrayList<>();
		Master jpaEntity = null;
		for(MasterDTO dtoEntity: dtoEntityList){
			jpaEntity = new Master();
            jpaEntity.setIdKit( dtoEntity.getIdKit());
            jpaEntity.setNombreEs( dtoEntity.getNombreEs());
            jpaEntity.setNombreEn( dtoEntity.getNombreEn());
            jpaEntity.setUrlMultimedia( dtoEntity.getUrlMultimedia());
            jpaEntity.setContenedor( dtoEntity.getContenedor());
            ParametrosDTO idUnidadMedidaDTO = new ParametrosDTO();
            idUnidadMedidaDTO.setIdParametro( dtoEntity.getIdUnidadMedida());
            jpaEntity.setIdUnidadMedida( ParametrosAssembler.buildJpaEntity( idUnidadMedidaDTO ));
            ParametrosDTO idInstruccionesNacionalesDTO = new ParametrosDTO();
            idInstruccionesNacionalesDTO.setIdParametro( dtoEntity.getIdInstruccionesNacionales());
            jpaEntity.setIdInstruccionesNacionales( ParametrosAssembler.buildJpaEntity( idInstruccionesNacionalesDTO ));
            ParametrosDTO idInstruccionesInternacDTO = new ParametrosDTO();
            idInstruccionesInternacDTO.setIdParametro( dtoEntity.getIdInstruccionesInternac());
            jpaEntity.setIdInstruccionesInternac( ParametrosAssembler.buildJpaEntity( idInstruccionesInternacDTO ));
            ParametrosDTO idTipoKitDTO = new ParametrosDTO();
            idTipoKitDTO.setIdParametro( dtoEntity.getIdTipoKit());
            jpaEntity.setIdTipoKit( ParametrosAssembler.buildJpaEntity( idTipoKitDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static MasterDTO buildDTOEntity(Master jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        MasterDTO dtoEntity =  new MasterDTO();		

        dtoEntity.setIdKit( jpaEntity.getIdKit() ); // primitive
        dtoEntity.setNombreEs( jpaEntity.getNombreEs() ); // primitive
        dtoEntity.setNombreEn( jpaEntity.getNombreEn() ); // primitive
        dtoEntity.setUrlMultimedia( jpaEntity.getUrlMultimedia() ); // primitive
        dtoEntity.setContenedor( jpaEntity.getContenedor() ); // primitive
        //Not Embedable: IdUnidadMedida -> Parametros, FTable: parametros, HyperName:ID_UNIDAD_MEDIDA
        dtoEntity.setIdUnidadMedida( jpaEntity.getIdUnidadMedida()!=null?jpaEntity.getIdUnidadMedida().getIdParametro():null);
        //Not Embedable: IdInstruccionesNacionales -> Parametros, FTable: parametros, HyperName:ID_INSTRUCCIONES_NACIONALES
        dtoEntity.setIdInstruccionesNacionales( jpaEntity.getIdInstruccionesNacionales()!=null?jpaEntity.getIdInstruccionesNacionales().getIdParametro():null);
        //Not Embedable: IdInstruccionesInternac -> Parametros, FTable: parametros, HyperName:ID_INSTRUCCIONES_INTERNAC
        dtoEntity.setIdInstruccionesInternac( jpaEntity.getIdInstruccionesInternac()!=null?jpaEntity.getIdInstruccionesInternac().getIdParametro():null);
        //Not Embedable: IdTipoKit -> Parametros, FTable: parametros, HyperName:ID_TIPO_KIT
        dtoEntity.setIdTipoKit( jpaEntity.getIdTipoKit()!=null?jpaEntity.getIdTipoKit().getIdParametro():null);

        return dtoEntity;
    }

	public static List<MasterDTO> buildDTOEntityList(List<Master> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<MasterDTO> dtoEntityList = new ArrayList<>();
        MasterDTO dtoEntity =  null;
		for(Master jpaEntity: jpaEntityList){
			dtoEntity =  new MasterDTO();
            dtoEntity.setIdKit( jpaEntity.getIdKit() );
            dtoEntity.setNombreEs( jpaEntity.getNombreEs() );
            dtoEntity.setNombreEn( jpaEntity.getNombreEn() );
            dtoEntity.setUrlMultimedia( jpaEntity.getUrlMultimedia() );
            dtoEntity.setContenedor( jpaEntity.getContenedor() );
            //Not Embedable: IdUnidadMedida -> Parametros, FTable: parametros, HyperName:ID_UNIDAD_MEDIDA
            dtoEntity.setIdUnidadMedida( jpaEntity.getIdUnidadMedida()!=null?jpaEntity.getIdUnidadMedida().getIdParametro():null);
            //Not Embedable: IdInstruccionesNacionales -> Parametros, FTable: parametros, HyperName:ID_INSTRUCCIONES_NACIONALES
            dtoEntity.setIdInstruccionesNacionales( jpaEntity.getIdInstruccionesNacionales()!=null?jpaEntity.getIdInstruccionesNacionales().getIdParametro():null);
            //Not Embedable: IdInstruccionesInternac -> Parametros, FTable: parametros, HyperName:ID_INSTRUCCIONES_INTERNAC
            dtoEntity.setIdInstruccionesInternac( jpaEntity.getIdInstruccionesInternac()!=null?jpaEntity.getIdInstruccionesInternac().getIdParametro():null);
            //Not Embedable: IdTipoKit -> Parametros, FTable: parametros, HyperName:ID_TIPO_KIT
            dtoEntity.setIdTipoKit( jpaEntity.getIdTipoKit()!=null?jpaEntity.getIdTipoKit().getIdParametro():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
