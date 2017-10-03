package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Pais;
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
public interface PaisFacadeLocal {

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
