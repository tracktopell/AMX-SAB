package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Vuelo;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Remote
public interface VueloFacadeRemote {

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
