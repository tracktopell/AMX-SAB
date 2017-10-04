package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.AvionSistemaEntretenimiento;
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
