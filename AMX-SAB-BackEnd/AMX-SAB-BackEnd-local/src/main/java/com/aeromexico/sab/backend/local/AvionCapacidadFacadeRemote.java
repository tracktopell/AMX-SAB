package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.AvionCapacidad;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */
@Remote
public interface AvionCapacidadFacadeRemote {

	AvionCapacidad create(AvionCapacidad entity);

	AvionCapacidad edit(AvionCapacidad entity);

	void remove(AvionCapacidad entity);

	AvionCapacidad findByPK(Object id);

	List<AvionCapacidad> findAllLike(AvionCapacidad entity);

	List<AvionCapacidad> findAll();

	List<AvionCapacidad> findRange(int[] range);

	Long count();

	Long countAll();

}
