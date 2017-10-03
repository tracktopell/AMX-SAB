package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Master;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Remote
public interface MasterFacadeRemote {

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
