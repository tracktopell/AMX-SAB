package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.CodigoServicio;
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
public interface CodigoServicioFacadeLocal {

	CodigoServicio create(CodigoServicio entity);

	CodigoServicio edit(CodigoServicio entity);

	void remove(CodigoServicio entity);

	CodigoServicio findByPK(Object id);

	List<CodigoServicio> findAllLike(CodigoServicio entity);

	List<CodigoServicio> findAll();

	List<CodigoServicio> findRange(int[] range);

	Long count();

	Long countAll();

}
