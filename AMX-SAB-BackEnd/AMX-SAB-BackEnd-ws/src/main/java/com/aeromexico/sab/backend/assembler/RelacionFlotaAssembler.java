package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.RelacionFlota;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table relacion_flota.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/03 13:52
 */

public class RelacionFlotaAssembler {    
    
    /** 
     * Private Constructor
     */
    private RelacionFlotaAssembler() {
    }

    public static RelacionFlota buildJpaEntity(RelacionFlotaDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		RelacionFlota jpaEntity = new RelacionFlota();

        jpaEntity.setIdRelacionFlota( dtoEntity.getIdRelacionFlota()); // normal
        jpaEntity.setRevision( dtoEntity.getRevision()); // normal
        jpaEntity.setFecha( dtoEntity.getFecha()); // normal

        return jpaEntity;
    }

    public static List<RelacionFlota> buildJpaEntityList(List<RelacionFlotaDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<RelacionFlota> jpaEntityList = new ArrayList<>();
		RelacionFlota jpaEntity = null;
		for(RelacionFlotaDTO dtoEntity: dtoEntityList){
			jpaEntity = new RelacionFlota();
            jpaEntity.setIdRelacionFlota( dtoEntity.getIdRelacionFlota());
            jpaEntity.setRevision( dtoEntity.getRevision());
            jpaEntity.setFecha( dtoEntity.getFecha());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static RelacionFlotaDTO buildDTOEntity(RelacionFlota jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        RelacionFlotaDTO dtoEntity =  new RelacionFlotaDTO();		

        dtoEntity.setIdRelacionFlota( jpaEntity.getIdRelacionFlota() ); // primitive
        dtoEntity.setRevision( jpaEntity.getRevision() ); // primitive
        dtoEntity.setFecha( jpaEntity.getFecha() ); // primitive

        return dtoEntity;
    }

	public static List<RelacionFlotaDTO> buildDTOEntityList(List<RelacionFlota> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<RelacionFlotaDTO> dtoEntityList = new ArrayList<>();
        RelacionFlotaDTO dtoEntity =  null;
		for(RelacionFlota jpaEntity: jpaEntityList){
			dtoEntity =  new RelacionFlotaDTO();
            dtoEntity.setIdRelacionFlota( jpaEntity.getIdRelacionFlota() );
            dtoEntity.setRevision( jpaEntity.getRevision() );
            dtoEntity.setFecha( jpaEntity.getFecha() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
