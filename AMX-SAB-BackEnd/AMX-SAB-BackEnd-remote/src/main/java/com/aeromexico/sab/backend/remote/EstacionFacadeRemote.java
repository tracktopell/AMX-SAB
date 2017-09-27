package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Estacion;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Remote
public interface EstacionFacadeRemote {

	Estacion create(Estacion entity);

	Estacion edit(Estacion entity);

	void remove(Estacion entity);

	Estacion findByPK(Object id);

	List<Estacion> findAllLike(Estacion entity);

	List<Estacion> findAll();

	List<Estacion> findRange(int[] range);

	Long count();

	Long countAll();

}
