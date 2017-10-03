package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.SistemaEntretenimiento;
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
public interface SistemaEntretenimientoFacadeLocal {

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
