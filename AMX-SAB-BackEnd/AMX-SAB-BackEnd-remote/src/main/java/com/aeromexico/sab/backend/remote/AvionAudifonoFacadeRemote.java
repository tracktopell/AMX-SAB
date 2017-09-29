package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.AvionAudifono;
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
public interface AvionAudifonoFacadeRemote {

	AvionAudifono create(AvionAudifono entity);

	AvionAudifono edit(AvionAudifono entity);

	void remove(AvionAudifono entity);

	AvionAudifono findByPK(Object id);

	List<AvionAudifono> findAllLike(AvionAudifono entity);

	List<AvionAudifono> findAll();

	List<AvionAudifono> findRange(int[] range);

	Long count();

	Long countAll();

}
