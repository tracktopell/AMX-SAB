package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Clase;
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
public interface ClaseFacadeLocal {

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
