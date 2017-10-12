package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Traduccion;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
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
