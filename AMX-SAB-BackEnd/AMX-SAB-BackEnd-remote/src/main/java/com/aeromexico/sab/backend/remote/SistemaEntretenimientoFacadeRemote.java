package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.SistemaEntretenimiento;
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
public interface SistemaEntretenimientoFacadeRemote {

	SistemaEntretenimiento create(SistemaEntretenimiento entity);

	SistemaEntretenimiento edit(SistemaEntretenimiento entity);

	void remove(SistemaEntretenimiento entity);

	SistemaEntretenimiento findByPK(Object id);

	List<SistemaEntretenimiento> findAllLike(SistemaEntretenimiento entity);

	List<SistemaEntretenimiento> findAll();

	List<SistemaEntretenimiento> findRange(int[] range);

	Long count();

	Long countAll();

}
