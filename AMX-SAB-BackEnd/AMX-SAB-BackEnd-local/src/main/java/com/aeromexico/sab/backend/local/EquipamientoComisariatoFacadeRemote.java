package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.EquipamientoComisariato;
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
