package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Perfil;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Remote
public interface PerfilFacadeRemote {

	Perfil create(Perfil entity);

	Perfil edit(Perfil entity);

	void remove(Perfil entity);

	Perfil findByPK(Object id);

	List<Perfil> findAllLike(Perfil entity);

	List<Perfil> findAll();

	List<Perfil> findRange(int[] range);

	Long count();

	Long countAll();

}
