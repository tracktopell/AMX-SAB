package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Clase;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Remote
public interface ClaseFacadeRemote {

	Clase create(Clase entity);

	Clase edit(Clase entity);

	void remove(Clase entity);

	Clase findByPK(Object id);

	List<Clase> findAllLike(Clase entity);

	List<Clase> findAll();

	List<Clase> findRange(int[] range);

	Long count();

	Long countAll();

}
