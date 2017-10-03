package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Vuelo;
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
public interface VueloFacadeLocal {

	Vuelo create(Vuelo entity);

	Vuelo edit(Vuelo entity);

	void remove(Vuelo entity);

	Vuelo findByPK(Object id);

	List<Vuelo> findAllLike(Vuelo entity);

	List<Vuelo> findAll();

	List<Vuelo> findRange(int[] range);

	Long count();

	Long countAll();

}
