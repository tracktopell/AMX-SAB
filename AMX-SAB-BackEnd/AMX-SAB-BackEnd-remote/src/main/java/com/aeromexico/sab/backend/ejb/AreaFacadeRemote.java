package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Area;
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
public interface AreaFacadeRemote {

	Area create(Area entity);

	Area edit(Area entity);

	void remove(Area entity);

	Area findByPK(Object id);

	List<Area> findAllLike(Area entity);

	List<Area> findAll();

	List<Area> findRange(int[] range);

	Long count();

	Long countAll();

}
