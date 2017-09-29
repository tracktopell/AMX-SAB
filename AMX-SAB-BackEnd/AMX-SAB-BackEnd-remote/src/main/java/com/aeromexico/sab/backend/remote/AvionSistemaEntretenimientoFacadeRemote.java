package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.AvionSistemaEntretenimiento;
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
public interface AvionSistemaEntretenimientoFacadeRemote {

	AvionSistemaEntretenimiento create(AvionSistemaEntretenimiento entity);

	AvionSistemaEntretenimiento edit(AvionSistemaEntretenimiento entity);

	void remove(AvionSistemaEntretenimiento entity);

	AvionSistemaEntretenimiento findByPK(Object id);

	List<AvionSistemaEntretenimiento> findAllLike(AvionSistemaEntretenimiento entity);

	List<AvionSistemaEntretenimiento> findAll();

	List<AvionSistemaEntretenimiento> findRange(int[] range);

	Long count();

	Long countAll();

}
