package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Modulo;
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
public interface ModuloFacadeLocal {

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
