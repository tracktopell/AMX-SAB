package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Material;
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
public interface MaterialFacadeLocal {

	Material create(Material entity);

	Material edit(Material entity);

	void remove(Material entity);

	Material findByPK(Object id);

	List<Material> findAllLike(Material entity);

	List<Material> findAll();

	List<Material> findRange(int[] range);

	Long count();

	Long countAll();

}
