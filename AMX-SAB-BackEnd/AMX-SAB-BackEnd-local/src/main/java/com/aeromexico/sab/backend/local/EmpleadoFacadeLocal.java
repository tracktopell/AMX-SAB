package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Empleado;
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
public interface EmpleadoFacadeLocal {

	Empleado create(Empleado entity);

	Empleado edit(Empleado entity);

	void remove(Empleado entity);

	Empleado findByPK(Object id);

	List<Empleado> findAllLike(Empleado entity);

	List<Empleado> findAll();

	List<Empleado> findRange(int[] range);

	Long count();

	Long countAll();

}
