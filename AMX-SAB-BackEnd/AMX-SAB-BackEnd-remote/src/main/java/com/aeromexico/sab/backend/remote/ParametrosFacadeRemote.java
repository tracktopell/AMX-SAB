package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Parametros;
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
public interface ParametrosFacadeRemote {

	Parametros create(Parametros entity);

	Parametros edit(Parametros entity);

	void remove(Parametros entity);

	Parametros findByPK(Object id);

	List<Parametros> findAllLike(Parametros entity);

	List<Parametros> findAll();

	List<Parametros> findRange(int[] range);

	Long count();

	Long countAll();

}
