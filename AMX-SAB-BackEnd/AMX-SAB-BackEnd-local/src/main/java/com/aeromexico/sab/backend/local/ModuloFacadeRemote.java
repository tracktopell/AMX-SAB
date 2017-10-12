package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Modulo;
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
public interface ModuloFacadeRemote {

	Modulo create(Modulo entity);

	Modulo edit(Modulo entity);

	void remove(Modulo entity);

	Modulo findByPK(Object id);

	List<Modulo> findAllLike(Modulo entity);

	List<Modulo> findAll();

	List<Modulo> findRange(int[] range);

	Long count();

	Long countAll();

}
