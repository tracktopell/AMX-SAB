package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Traduccion;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Remote
public interface TraduccionFacadeRemote {

	Traduccion create(Traduccion entity);

	Traduccion edit(Traduccion entity);

	void remove(Traduccion entity);

	Traduccion findByPK(Object id);

	List<Traduccion> findAllLike(Traduccion entity);

	List<Traduccion> findAll();

	List<Traduccion> findRange(int[] range);

	Long count();

	Long countAll();

}
