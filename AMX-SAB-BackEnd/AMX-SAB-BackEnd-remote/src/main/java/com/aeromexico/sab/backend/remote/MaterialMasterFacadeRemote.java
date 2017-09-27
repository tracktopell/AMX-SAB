package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.MaterialMaster;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Remote
public interface MaterialMasterFacadeRemote {

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
