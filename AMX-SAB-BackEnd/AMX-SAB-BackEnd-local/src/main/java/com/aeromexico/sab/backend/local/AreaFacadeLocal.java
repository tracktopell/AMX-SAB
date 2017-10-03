package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Area;
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
public interface AreaFacadeLocal {

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
