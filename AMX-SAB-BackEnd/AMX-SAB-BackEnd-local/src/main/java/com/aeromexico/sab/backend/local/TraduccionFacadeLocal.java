package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Traduccion;
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
public interface TraduccionFacadeLocal {

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
