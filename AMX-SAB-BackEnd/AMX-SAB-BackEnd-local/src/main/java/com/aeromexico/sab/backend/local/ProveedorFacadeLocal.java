package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Proveedor;
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
public interface ProveedorFacadeLocal {

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
