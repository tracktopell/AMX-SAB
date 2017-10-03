package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Region;
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
public interface RegionFacadeLocal {

	Region create(Region entity);

	Region edit(Region entity);

	void remove(Region entity);

	Region findByPK(Object id);

	List<Region> findAllLike(Region entity);

	List<Region> findAll();

	List<Region> findRange(int[] range);

	Long count();

	Long countAll();

}
