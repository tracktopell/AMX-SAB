package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.RelacionFlota;
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
public interface RelacionFlotaFacadeLocal {

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
