package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Ciudad;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Remote
public interface CiudadFacadeRemote {

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
