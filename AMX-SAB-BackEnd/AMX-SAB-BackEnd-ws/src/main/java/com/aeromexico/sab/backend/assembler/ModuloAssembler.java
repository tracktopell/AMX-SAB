package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Modulo;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table modulo.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/03 13:52
 */

public class ModuloAssembler {    
    
    /** 
     * Private Constructor
     */
    private ModuloAssembler() {
    }

    public static Modulo buildJpaEntity(ModuloDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Modulo jpaEntity = new Modulo();

        jpaEntity.setIdModulo( dtoEntity.getIdModulo()); // normal
        ModuloDTO moduloPadreDTO = new ModuloDTO();
        moduloPadreDTO.setIdModulo( dtoEntity.getIdModuloPadre());
        jpaEntity.setModuloPadre( ModuloAssembler.buildJpaEntity( moduloPadreDTO ));
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setUri( dtoEntity.getUri()); // normal

        return jpaEntity;
    }

    public static List<Modulo> buildJpaEntityList(List<ModuloDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Modulo> jpaEntityList = new ArrayList<>();
		Modulo jpaEntity = null;
		for(ModuloDTO dtoEntity: dtoEntityList){
			jpaEntity = new Modulo();
            jpaEntity.setIdModulo( dtoEntity.getIdModulo());
            ModuloDTO moduloPadreDTO = new ModuloDTO();
            moduloPadreDTO.setIdModulo( dtoEntity.getIdModuloPadre());
            jpaEntity.setModuloPadre( ModuloAssembler.buildJpaEntity( moduloPadreDTO ));
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setUri( dtoEntity.getUri());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ModuloDTO buildDTOEntity(Modulo jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ModuloDTO dtoEntity =  new ModuloDTO();		

        dtoEntity.setIdModulo( jpaEntity.getIdModulo() ); // primitive
        //Not Embedable: IdModuloPadre -> Modulo, FTable: modulo, HyperName:modulo_PADRE
        dtoEntity.setIdModuloPadre( jpaEntity.getModuloPadre()!=null?jpaEntity.getModuloPadre().getIdModulo():null);
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setUri( jpaEntity.getUri() ); // primitive

        return dtoEntity;
    }

	public static List<ModuloDTO> buildDTOEntityList(List<Modulo> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ModuloDTO> dtoEntityList = new ArrayList<>();
        ModuloDTO dtoEntity =  null;
		for(Modulo jpaEntity: jpaEntityList){
			dtoEntity =  new ModuloDTO();
            dtoEntity.setIdModulo( jpaEntity.getIdModulo() );
            //Not Embedable: IdModuloPadre -> Modulo, FTable: modulo, HyperName:modulo_PADRE
            dtoEntity.setIdModuloPadre( jpaEntity.getModuloPadre()!=null?jpaEntity.getModuloPadre().getIdModulo():null);
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setUri( jpaEntity.getUri() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
