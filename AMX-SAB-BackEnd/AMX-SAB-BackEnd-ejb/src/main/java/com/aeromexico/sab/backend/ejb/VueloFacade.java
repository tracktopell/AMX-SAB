package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Vuelo;
import com.aeromexico.sab.backend.remote.VueloFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table vuelo.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Stateless
public class VueloFacade extends AbstractFacade<Vuelo> implements VueloFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public VueloFacade() {
		super(Vuelo.class);
	}

	@Override
	public List<Vuelo> findAllLike(Vuelo x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Vuelo x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdVuelo() != null){
			    paramAsigned++;
			    sbq.append(" and x.idVuelo = :idVuelo");
			}
			if(x.getNumeroVuelo()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.numeroVuelo = :numeroVuelo");
			}
			if(x.getTipoVuelo() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoVuelo = :tipoVuelo");
			}
			if(x.getEstacionOrigen() != null){
			    paramAsigned++;
			    sbq.append(" and x.estacionOrigen = :estacionOrigen");
			}
			if(x.getEstacionDestino() != null){
			    paramAsigned++;
			    sbq.append(" and x.estacionDestino = :estacionDestino");
			}
			if(x.getTipoCabina() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoCabina = :tipoCabina");
			}
			if(x.getCompania() != null){
			    paramAsigned++;
			    sbq.append(" and x.compania = :compania");
			}
			if(x.getClase() != null){
			    paramAsigned++;
			    sbq.append(" and x.clase = :clase");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Vuelo> nq = em.createQuery(sbq.toString(), Vuelo.class);
		
		if(paramAsigned>0){
			if(x.getIdVuelo() != null){
			    nq.setParameter("idVuelo",x.getIdVuelo());
			}
			if(x.getNumeroVuelo()  != 0){
			    nq.setParameter("numeroVuelo",x.getNumeroVuelo());
			}
			if(x.getTipoVuelo() != null){
			    nq.setParameter("tipoVuelo",x.getTipoVuelo());
			}
			if(x.getEstacionOrigen() != null){
			    nq.setParameter("estacionOrigen",x.getEstacionOrigen());
			}
			if(x.getEstacionDestino() != null){
			    nq.setParameter("estacionDestino",x.getEstacionDestino());
			}
			if(x.getTipoCabina() != null){
			    nq.setParameter("tipoCabina",x.getTipoCabina());
			}
			if(x.getCompania() != null){
			    nq.setParameter("compania",x.getCompania());
			}
			if(x.getClase() != null){
			    nq.setParameter("clase",x.getClase());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Vuelo> findAll() {
		TypedQuery<Vuelo> nq = em.createNamedQuery("Vuelo.findAll", Vuelo.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Vuelo.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
