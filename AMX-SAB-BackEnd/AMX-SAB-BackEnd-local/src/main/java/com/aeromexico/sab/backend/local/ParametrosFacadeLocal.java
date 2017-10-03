package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Parametros;
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
public interface ParametrosFacadeLocal {

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
