package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Perfil;
import java.util.List;
import javax.ejb.Local;

/**
 * JPA Entity @Local Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/02 18:43
 */
@Local
public interface PerfilFacadeLocal {

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
