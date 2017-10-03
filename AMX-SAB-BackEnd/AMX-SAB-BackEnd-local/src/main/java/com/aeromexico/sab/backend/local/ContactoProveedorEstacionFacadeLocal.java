package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.ContactoProveedorEstacion;
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
public interface ContactoProveedorEstacionFacadeLocal {

	ContactoProveedorEstacion create(ContactoProveedorEstacion entity);

	ContactoProveedorEstacion edit(ContactoProveedorEstacion entity);

	void remove(ContactoProveedorEstacion entity);

	ContactoProveedorEstacion findByPK(Object id);

	List<ContactoProveedorEstacion> findAllLike(ContactoProveedorEstacion entity);

	List<ContactoProveedorEstacion> findAll();

	List<ContactoProveedorEstacion> findRange(int[] range);

	Long count();

	Long countAll();

}
