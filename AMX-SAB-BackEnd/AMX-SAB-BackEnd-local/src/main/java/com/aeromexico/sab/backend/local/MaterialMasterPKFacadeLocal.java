package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.MaterialMasterPK;
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
public interface MaterialMasterPKFacadeLocal {

	MaterialMasterPK create(MaterialMasterPK entity);

	MaterialMasterPK edit(MaterialMasterPK entity);

	void remove(MaterialMasterPK entity);

	MaterialMasterPK findByPK(Object id);

	List<MaterialMasterPK> findAllLike(MaterialMasterPK entity);

	List<MaterialMasterPK> findAll();

	List<MaterialMasterPK> findRange(int[] range);

	Long count();

	Long countAll();

}
