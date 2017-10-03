package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.MaterialMaster;
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
public interface MaterialMasterFacadeLocal {

	MaterialMaster create(MaterialMaster entity);

	MaterialMaster edit(MaterialMaster entity);

	void remove(MaterialMaster entity);

	MaterialMaster findByPK(Object id);

	List<MaterialMaster> findAllLike(MaterialMaster entity);

	List<MaterialMaster> findAll();

	List<MaterialMaster> findRange(int[] range);

	Long count();

	Long countAll();

}
