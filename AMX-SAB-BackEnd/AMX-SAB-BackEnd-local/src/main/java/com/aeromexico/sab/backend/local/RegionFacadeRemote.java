package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Region;
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
public interface RegionFacadeRemote {

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
