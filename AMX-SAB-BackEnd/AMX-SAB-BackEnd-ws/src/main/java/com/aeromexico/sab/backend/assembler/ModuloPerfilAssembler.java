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
 * @date 2017/09/28 19:09
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
        jpaEntity.getModuloPerfilPK().setPerfilidPerfil( dtoEntity.getPerfilidPerfil() );  // nested FKs > BUG
        jpaEntity.getModuloPerfilPK().setModuloidModulo( dtoEntity.getModuloidModulo() );  // nested FKs > BUG
        // End nested settings
        jpaEntity.setPermisoRwd( dtoEntity.getPermisoRwd()); // normal
        ModuloDTO modulomoduloDTO = new ModuloDTO();
        modulomoduloDTO.setIdModulo( dtoEntity.getModuloidModulo());
        jpaEntity.setModulomodulo( ModuloAssembler.buildJpaEntity( modulomoduloDTO ));
        PerfilDTO perfilperfilDTO = new PerfilDTO();
        perfilperfilDTO.setIdPerfil( dtoEntity.getPerfilidPerfil());
        jpaEntity.setPerfilperfil( PerfilAssembler.buildJpaEntity( perfilperfilDTO ));

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
            jpaEntity.getModuloPerfilPK().setPerfilidPerfil( dtoEntity.getPerfilidPerfil() );  // nested FKs > BUG
            jpaEntity.getModuloPerfilPK().setModuloidModulo( dtoEntity.getModuloidModulo() );  // nested FKs > BUG
            // End nested settings
            jpaEntity.setPermisoRwd( dtoEntity.getPermisoRwd());
            ModuloDTO modulomoduloDTO = new ModuloDTO();
            modulomoduloDTO.setIdModulo( dtoEntity.getModuloidModulo());
            jpaEntity.setModulomodulo( ModuloAssembler.buildJpaEntity( modulomoduloDTO ));
            PerfilDTO perfilperfilDTO = new PerfilDTO();
            perfilperfilDTO.setIdPerfil( dtoEntity.getPerfilidPerfil());
            jpaEntity.setPerfilperfil( PerfilAssembler.buildJpaEntity( perfilperfilDTO ));
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
        dtoEntity.setPerfilidPerfil( jpaEntity.getModuloPerfilPK().getPerfilidPerfil() ); // bug 3 ?
        dtoEntity.setModuloidModulo( jpaEntity.getModuloPerfilPK().getModuloidModulo() ); // bug 3 ?
        // End nested settings
        dtoEntity.setPermisoRwd( jpaEntity.getPermisoRwd() ); // primitive
        //Not Embedable: ModuloidModulo -> Modulo, FTable: modulo, HyperName:moduloMODULO
        dtoEntity.setModuloidModulo( jpaEntity.getModulomodulo()!=null?jpaEntity.getModulomodulo().getIdModulo():null);
        //Not Embedable: PerfilidPerfil -> Perfil, FTable: perfil, HyperName:perfilPERFIL
        dtoEntity.setPerfilidPerfil( jpaEntity.getPerfilperfil()!=null?jpaEntity.getPerfilperfil().getIdPerfil():null);

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
            dtoEntity.setPerfilidPerfil( jpaEntity.getModuloPerfilPK().getPerfilidPerfil() );
            dtoEntity.setModuloidModulo( jpaEntity.getModuloPerfilPK().getModuloidModulo() );
            // End nested settings
            dtoEntity.setPermisoRwd( jpaEntity.getPermisoRwd() );
            //Not Embedable: ModuloidModulo -> Modulo, FTable: modulo, HyperName:moduloMODULO
            dtoEntity.setModuloidModulo( jpaEntity.getModulomodulo()!=null?jpaEntity.getModulomodulo().getIdModulo():null);
            //Not Embedable: PerfilidPerfil -> Perfil, FTable: perfil, HyperName:perfilPERFIL
            dtoEntity.setPerfilidPerfil( jpaEntity.getPerfilperfil()!=null?jpaEntity.getPerfilperfil().getIdPerfil():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
