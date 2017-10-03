package com.aeromexico.sab.api.remote;

import com.aeromexico.sab.api.PerfilService;
import com.aeromexico.sab.dto.PerfilDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author alfredo
 */
@Remote
public interface PerfilRemoteService extends PerfilService {
	public List<PerfilDTO> getAll();
}
