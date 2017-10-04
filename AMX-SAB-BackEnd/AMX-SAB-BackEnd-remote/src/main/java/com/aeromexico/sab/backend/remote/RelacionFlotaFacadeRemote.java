package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.RelacionFlota;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Remote
public interface RelacionFlotaFacadeRemote {

	RelacionFlota create(RelacionFlota entity);

	RelacionFlota edit(RelacionFlota entity);

	void remove(RelacionFlota entity);

	RelacionFlota findByPK(Object id);

	List<RelacionFlota> findAllLike(RelacionFlota entity);

	List<RelacionFlota> findAll();

	List<RelacionFlota> findRange(int[] range);

	Long count();

	Long countAll();

}
