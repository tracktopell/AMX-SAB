package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.CategoriaMaterial;
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
public interface CategoriaMaterialFacadeLocal {

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
