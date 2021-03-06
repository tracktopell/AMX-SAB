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
 * @date 2017/10/04 07:27
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

        jpaEntity.setEmailUsuario( dtoEntity.getEmailUsuario()); // normal
        jpaEntity.setContrasenia( dtoEntity.getContrasenia()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setApellidoPaterno( dtoEntity.getApellidoPaterno()); // normal
        jpaEntity.setApellidoMaterno( dtoEntity.getApellidoMaterno()); // normal
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
            jpaEntity.setEmailUsuario( dtoEntity.getEmailUsuario());
            jpaEntity.setContrasenia( dtoEntity.getContrasenia());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setApellidoPaterno( dtoEntity.getApellidoPaterno());
            jpaEntity.setApellidoMaterno( dtoEntity.getApellidoMaterno());
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

        dtoEntity.setEmailUsuario( jpaEntity.getEmailUsuario() ); // primitive
        dtoEntity.setContrasenia( jpaEntity.getContrasenia() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setApellidoPaterno( jpaEntity.getApellidoPaterno() ); // primitive
        dtoEntity.setApellidoMaterno( jpaEntity.getApellidoMaterno() ); // primitive
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
            dtoEntity.setEmailUsuario( jpaEntity.getEmailUsuario() );
            dtoEntity.setContrasenia( jpaEntity.getContrasenia() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setApellidoPaterno( jpaEntity.getApellidoPaterno() );
            dtoEntity.setApellidoMaterno( jpaEntity.getApellidoMaterno() );
            dtoEntity.setEstatus( jpaEntity.getEstatus() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
