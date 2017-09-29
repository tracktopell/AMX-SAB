package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Pais;
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
public interface PaisFacadeRemote {

	Pais create(Pais entity);

	Pais edit(Pais entity);

	void remove(Pais entity);

	Pais findByPK(Object id);

	List<Pais> findAllLike(Pais entity);

	List<Pais> findAll();

	List<Pais> findRange(int[] range);

	Long count();

	Long countAll();

}
