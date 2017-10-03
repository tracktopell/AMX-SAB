package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.ModeloAvion;
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
public interface ModeloAvionFacadeLocal {

	ModeloAvion create(ModeloAvion entity);

	ModeloAvion edit(ModeloAvion entity);

	void remove(ModeloAvion entity);

	ModeloAvion findByPK(Object id);

	List<ModeloAvion> findAllLike(ModeloAvion entity);

	List<ModeloAvion> findAll();

	List<ModeloAvion> findRange(int[] range);

	Long count();

	Long countAll();

}
