package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.TipoEquipoAvion;
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
public interface TipoEquipoAvionFacadeRemote {

	TipoEquipoAvion create(TipoEquipoAvion entity);

	TipoEquipoAvion edit(TipoEquipoAvion entity);

	void remove(TipoEquipoAvion entity);

	TipoEquipoAvion findByPK(Object id);

	List<TipoEquipoAvion> findAllLike(TipoEquipoAvion entity);

	List<TipoEquipoAvion> findAll();

	List<TipoEquipoAvion> findRange(int[] range);

	Long count();

	Long countAll();

}
