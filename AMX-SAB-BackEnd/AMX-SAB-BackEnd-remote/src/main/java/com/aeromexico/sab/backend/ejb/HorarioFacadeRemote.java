package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Horario;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Remote
public interface HorarioFacadeRemote {

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
