package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Empleado;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Remote
public interface EmpleadoFacadeRemote {

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
