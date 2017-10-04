package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.MaterialMasterPK;
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
public interface MaterialMasterPKFacadeRemote {

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
