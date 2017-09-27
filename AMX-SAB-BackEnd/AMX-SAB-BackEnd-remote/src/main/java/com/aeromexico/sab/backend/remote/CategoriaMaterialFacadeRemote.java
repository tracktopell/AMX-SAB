package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.CategoriaMaterial;
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
public interface CategoriaMaterialFacadeRemote {

	CategoriaMaterial create(CategoriaMaterial entity);

	CategoriaMaterial edit(CategoriaMaterial entity);

	void remove(CategoriaMaterial entity);

	CategoriaMaterial findByPK(Object id);

	List<CategoriaMaterial> findAllLike(CategoriaMaterial entity);

	List<CategoriaMaterial> findAll();

	List<CategoriaMaterial> findRange(int[] range);

	Long count();

	Long countAll();

}
