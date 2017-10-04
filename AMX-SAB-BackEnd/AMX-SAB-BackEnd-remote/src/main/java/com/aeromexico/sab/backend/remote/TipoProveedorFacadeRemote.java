package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.TipoProveedor;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
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
