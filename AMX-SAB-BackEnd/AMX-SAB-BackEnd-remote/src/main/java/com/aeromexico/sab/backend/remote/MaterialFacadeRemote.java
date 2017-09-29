package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Material;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */
@Remote
public interface MaterialFacadeRemote {

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
