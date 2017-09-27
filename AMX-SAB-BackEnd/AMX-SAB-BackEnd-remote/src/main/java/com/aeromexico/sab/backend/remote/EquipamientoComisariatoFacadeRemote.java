package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.EquipamientoComisariato;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Remote
public interface EquipamientoComisariatoFacadeRemote {

	EquipamientoComisariato create(EquipamientoComisariato entity);

	EquipamientoComisariato edit(EquipamientoComisariato entity);

	void remove(EquipamientoComisariato entity);

	EquipamientoComisariato findByPK(Object id);

	List<EquipamientoComisariato> findAllLike(EquipamientoComisariato entity);

	List<EquipamientoComisariato> findAll();

	List<EquipamientoComisariato> findRange(int[] range);

	Long count();

	Long countAll();

}
