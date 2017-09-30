package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ModeloAvion;
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
public interface ModeloAvionFacadeRemote {

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
