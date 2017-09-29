package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Compania;
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
public interface CompaniaFacadeRemote {

	Compania create(Compania entity);

	Compania edit(Compania entity);

	void remove(Compania entity);

	Compania findByPK(Object id);

	List<Compania> findAllLike(Compania entity);

	List<Compania> findAll();

	List<Compania> findRange(int[] range);

	Long count();

	Long countAll();

}
