package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.CodigoServicio;
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
public interface CodigoServicioFacadeRemote {

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
