package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Ciudad;
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
public interface CiudadFacadeLocal {

	Ciudad create(Ciudad entity);

	Ciudad edit(Ciudad entity);

	void remove(Ciudad entity);

	Ciudad findByPK(Object id);

	List<Ciudad> findAllLike(Ciudad entity);

	List<Ciudad> findAll();

	List<Ciudad> findRange(int[] range);

	Long count();

	Long countAll();

}
