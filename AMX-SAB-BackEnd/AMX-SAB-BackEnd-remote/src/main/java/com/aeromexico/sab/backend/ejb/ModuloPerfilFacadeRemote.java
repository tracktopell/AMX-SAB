package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ModuloPerfil;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Remote
public interface ModuloPerfilFacadeRemote {

	ModuloPerfil create(ModuloPerfil entity);

	ModuloPerfil edit(ModuloPerfil entity);

	void remove(ModuloPerfil entity);

	ModuloPerfil findByPK(Object id);

	List<ModuloPerfil> findAllLike(ModuloPerfil entity);

	List<ModuloPerfil> findAll();

	List<ModuloPerfil> findRange(int[] range);

	Long count();

	Long countAll();

}
