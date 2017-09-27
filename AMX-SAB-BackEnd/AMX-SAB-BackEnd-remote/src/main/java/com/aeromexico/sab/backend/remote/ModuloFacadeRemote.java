package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Modulo;
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
