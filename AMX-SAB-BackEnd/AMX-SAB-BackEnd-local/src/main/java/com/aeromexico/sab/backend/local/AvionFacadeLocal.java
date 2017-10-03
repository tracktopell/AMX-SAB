package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Avion;
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
public interface AvionFacadeLocal {

	Avion create(Avion entity);

	Avion edit(Avion entity);

	void remove(Avion entity);

	Avion findByPK(Object id);

	List<Avion> findAllLike(Avion entity);

	List<Avion> findAll();

	List<Avion> findRange(int[] range);

	Long count();

	Long countAll();

}
