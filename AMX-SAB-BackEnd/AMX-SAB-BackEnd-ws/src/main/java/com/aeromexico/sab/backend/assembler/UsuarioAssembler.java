package com.aeromexico.sab.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.aeromexico.sab.dto.*;
import com.aeromexico.sab.backend.entity.Usuario;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table usuario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/09/30 07:39
 */

public class UsuarioAssembler {    
    
    /** 
     * Private Constructor
     */
    private UsuarioAssembler() {
    }

    public static Usuario buildJpaEntity(UsuarioDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Usuario jpaEntity = new Usuario();

        jpaEntity.setIdUsuario( dtoEntity.getIdUsuario()); // normal
        jpaEntity.setEmail( dtoEntity.getEmail()); // normal
        jpaEntity.setContrasenia( dtoEntity.getContrasenia()); // normal
        jpaEntity.setEstatus( dtoEntity.getEstatus()); // normal

        return jpaEntity;
    }

    public static List<Usuario> buildJpaEntityList(List<UsuarioDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Usuario> jpaEntityList = new ArrayList<>();
		Usuario jpaEntity = null;
		for(UsuarioDTO dtoEntity: dtoEntityList){
			jpaEntity = new Usuario();
            jpaEntity.setIdUsuario( dtoEntity.getIdUsuario());
            jpaEntity.setEmail( dtoEntity.getEmail());
            jpaEntity.setContrasenia( dtoEntity.getContrasenia());
            jpaEntity.setEstatus( dtoEntity.getEstatus());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static UsuarioDTO buildDTOEntity(Usuario jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        UsuarioDTO dtoEntity =  new UsuarioDTO();		

        dtoEntity.setIdUsuario( jpaEntity.getIdUsuario() ); // primitive
        dtoEntity.setEmail( jpaEntity.getEmail() ); // primitive
        dtoEntity.setContrasenia( jpaEntity.getContrasenia() ); // primitive
        dtoEntity.setEstatus( jpaEntity.getEstatus() ); // primitive

        return dtoEntity;
    }

	public static List<UsuarioDTO> buildDTOEntityList(List<Usuario> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<UsuarioDTO> dtoEntityList = new ArrayList<>();
        UsuarioDTO dtoEntity =  null;
		for(Usuario jpaEntity: jpaEntityList){
			dtoEntity =  new UsuarioDTO();
            dtoEntity.setIdUsuario( jpaEntity.getIdUsuario() );
            dtoEntity.setEmail( jpaEntity.getEmail() );
            dtoEntity.setContrasenia( jpaEntity.getContrasenia() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
