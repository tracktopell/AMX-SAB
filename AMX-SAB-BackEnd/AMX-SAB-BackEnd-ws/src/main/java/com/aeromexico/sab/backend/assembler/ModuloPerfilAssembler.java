package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.ModuloPerfil;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table modulo_perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/04 07:27
 */

public class ModuloPerfilAssembler {    
    
    /** 
     * Private Constructor
     */
    private ModuloPerfilAssembler() {
    }

    public static ModuloPerfil buildJpaEntity(ModuloPerfilDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		ModuloPerfil jpaEntity = new ModuloPerfil();

        // ModuloPerfilPK is Embeddable. Begin nested settings
        jpaEntity.getModuloPerfilPK().setPerfil( dtoEntity.getPerfil() );  // nested FKs > BUG
        jpaEntity.getModuloPerfilPK().setIdModulo( dtoEntity.getIdModulo() );  // nested FKs > BUG
        // End nested settings
        jpaEntity.setPermisoRwd( dtoEntity.getPermisoRwd()); // normal
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setIdModulo( dtoEntity.getIdModulo());
        jpaEntity.setModulo( ModuloAssembler.buildJpaEntity( moduloDTO ));
        PerfilDTO perfilDTO = new PerfilDTO();
        perfilDTO.setPerfil( dtoEntity.getPerfil());
        jpaEntity.setPerfil( PerfilAssembler.buildJpaEntity( perfilDTO ));

        return jpaEntity;
    }

    public static List<ModuloPerfil> buildJpaEntityList(List<ModuloPerfilDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<ModuloPerfil> jpaEntityList = new ArrayList<>();
		ModuloPerfil jpaEntity = null;
		for(ModuloPerfilDTO dtoEntity: dtoEntityList){
			jpaEntity = new ModuloPerfil();
            // ModuloPerfilPK is Embeddable. Begin nested settings
            jpaEntity.getModuloPerfilPK().setPerfil( dtoEntity.getPerfil() );  // nested FKs > BUG
            jpaEntity.getModuloPerfilPK().setIdModulo( dtoEntity.getIdModulo() );  // nested FKs > BUG
            // End nested settings
            jpaEntity.setPermisoRwd( dtoEntity.getPermisoRwd());
            ModuloDTO moduloDTO = new ModuloDTO();
            moduloDTO.setIdModulo( dtoEntity.getIdModulo());
            jpaEntity.setModulo( ModuloAssembler.buildJpaEntity( moduloDTO ));
            PerfilDTO perfilDTO = new PerfilDTO();
            perfilDTO.setPerfil( dtoEntity.getPerfil());
            jpaEntity.setPerfil( PerfilAssembler.buildJpaEntity( perfilDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ModuloPerfilDTO buildDTOEntity(ModuloPerfil jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ModuloPerfilDTO dtoEntity =  new ModuloPerfilDTO();		

        // Embedable: ModuloPerfilPK, begin nested settings
        dtoEntity.setPerfil( jpaEntity.getModuloPerfilPK().getPerfil() ); // bug 3 ?
        dtoEntity.setIdModulo( jpaEntity.getModuloPerfilPK().getIdModulo() ); // bug 3 ?
        // End nested settings
        dtoEntity.setPermisoRwd( jpaEntity.getPermisoRwd() ); // primitive
        //Not Embedable: IdModulo -> Modulo, FTable: modulo, HyperName:modulo
        dtoEntity.setIdModulo( jpaEntity.getModulo()!=null?jpaEntity.getModulo().getIdModulo():null);
        //Not Embedable: Perfil -> Perfil, FTable: perfil, HyperName:perfil
        dtoEntity.setPerfil( jpaEntity.getPerfil()!=null?jpaEntity.getPerfil().getPerfil():null);

        return dtoEntity;
    }

	public static List<ModuloPerfilDTO> buildDTOEntityList(List<ModuloPerfil> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ModuloPerfilDTO> dtoEntityList = new ArrayList<>();
        ModuloPerfilDTO dtoEntity =  null;
		for(ModuloPerfil jpaEntity: jpaEntityList){
			dtoEntity =  new ModuloPerfilDTO();
            // Embedable: ModuloPerfilPK, begin nested settings
            dtoEntity.setPerfil( jpaEntity.getModuloPerfilPK().getPerfil() );
            dtoEntity.setIdModulo( jpaEntity.getModuloPerfilPK().getIdModulo() );
            // End nested settings
            dtoEntity.setPermisoRwd( jpaEntity.getPermisoRwd() );
            //Not Embedable: IdModulo -> Modulo, FTable: modulo, HyperName:modulo
            dtoEntity.setIdModulo( jpaEntity.getModulo()!=null?jpaEntity.getModulo().getIdModulo():null);
            //Not Embedable: Perfil -> Perfil, FTable: perfil, HyperName:perfil
            dtoEntity.setPerfil( jpaEntity.getPerfil()!=null?jpaEntity.getPerfil().getPerfil():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
