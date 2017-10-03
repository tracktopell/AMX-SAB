package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Master;
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
public interface MasterFacadeLocal {

	Master create(Master entity);

	Master edit(Master entity);

	void remove(Master entity);

	Master findByPK(Object id);

	List<Master> findAllLike(Master entity);

	List<Master> findAll();

	List<Master> findRange(int[] range);

	Long count();

	Long countAll();

}
