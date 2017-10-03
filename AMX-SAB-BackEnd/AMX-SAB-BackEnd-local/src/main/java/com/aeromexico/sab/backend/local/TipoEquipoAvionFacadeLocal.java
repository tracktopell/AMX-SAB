package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.TipoEquipoAvion;
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
public interface TipoEquipoAvionFacadeLocal {

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
