package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.ContactoProveedorEstacion;
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
public interface ContactoProveedorEstacionFacadeRemote {

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
