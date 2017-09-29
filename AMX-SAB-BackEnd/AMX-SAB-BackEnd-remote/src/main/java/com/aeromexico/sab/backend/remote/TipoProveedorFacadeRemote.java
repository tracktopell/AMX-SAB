package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.TipoProveedor;
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
public interface TipoProveedorFacadeRemote {

	TipoProveedor create(TipoProveedor entity);

	TipoProveedor edit(TipoProveedor entity);

	void remove(TipoProveedor entity);

	TipoProveedor findByPK(Object id);

	List<TipoProveedor> findAllLike(TipoProveedor entity);

	List<TipoProveedor> findAll();

	List<TipoProveedor> findRange(int[] range);

	Long count();

	Long countAll();

}
