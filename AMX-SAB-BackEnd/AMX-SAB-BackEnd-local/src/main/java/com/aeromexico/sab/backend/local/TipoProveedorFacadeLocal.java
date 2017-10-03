package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.TipoProveedor;
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
public interface TipoProveedorFacadeLocal {

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
