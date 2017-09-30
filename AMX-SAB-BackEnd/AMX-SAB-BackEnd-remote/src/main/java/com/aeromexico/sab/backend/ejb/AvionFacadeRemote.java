package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Avion;
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
public interface AvionFacadeRemote {

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
