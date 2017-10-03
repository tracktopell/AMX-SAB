package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.AvionSistemaEntretenimiento;
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
public interface AvionSistemaEntretenimientoFacadeLocal {

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
