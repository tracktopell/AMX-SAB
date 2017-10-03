package com.aeromexico.sab.api.remote;

import com.aeromexico.sab.api.UsuarioService;
import com.aeromexico.sab.dto.UsuarioDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author alfredo
 */
@Remote
public interface UsuarioRemoteService extends UsuarioService{
	public List<UsuarioDTO> getAll();
}
