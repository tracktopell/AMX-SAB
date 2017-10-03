package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Horario;
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
public interface HorarioFacadeLocal {

	Horario create(Horario entity);

	Horario edit(Horario entity);

	void remove(Horario entity);

	Horario findByPK(Object id);

	List<Horario> findAllLike(Horario entity);

	List<Horario> findAll();

	List<Horario> findRange(int[] range);

	Long count();

	Long countAll();

}
