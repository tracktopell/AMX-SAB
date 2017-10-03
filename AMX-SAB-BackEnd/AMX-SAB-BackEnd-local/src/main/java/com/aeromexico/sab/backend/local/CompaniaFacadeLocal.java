package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Compania;
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
public interface CompaniaFacadeLocal {

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
