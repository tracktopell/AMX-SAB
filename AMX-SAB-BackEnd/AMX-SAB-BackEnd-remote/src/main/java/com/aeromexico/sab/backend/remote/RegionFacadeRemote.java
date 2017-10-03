package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Region;
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
