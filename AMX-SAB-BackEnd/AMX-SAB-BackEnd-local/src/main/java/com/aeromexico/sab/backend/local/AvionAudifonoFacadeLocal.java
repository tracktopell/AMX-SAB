package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.AvionAudifono;
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
public interface AvionAudifonoFacadeLocal {

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
