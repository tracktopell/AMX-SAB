package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Proveedor;
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
public interface ProveedorFacadeRemote {

	Proveedor create(Proveedor entity);

	Proveedor edit(Proveedor entity);

	void remove(Proveedor entity);

	Proveedor findByPK(Object id);

	List<Proveedor> findAllLike(Proveedor entity);

	List<Proveedor> findAll();

	List<Proveedor> findRange(int[] range);

	Long count();

	Long countAll();

}
