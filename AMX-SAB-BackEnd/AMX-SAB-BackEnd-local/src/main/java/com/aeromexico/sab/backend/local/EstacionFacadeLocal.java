package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Estacion;
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
public interface EstacionFacadeLocal {

	Estacion create(Estacion entity);

	Estacion edit(Estacion entity);

	void remove(Estacion entity);

	Estacion findByPK(Object id);

	List<Estacion> findAllLike(Estacion entity);

	List<Estacion> findAll();

	List<Estacion> findRange(int[] range);

	Long count();

	Long countAll();

}
