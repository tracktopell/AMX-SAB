package com.aeromexico.sab.backend.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Embeddable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Hibernate Validator 5x is not compatible with validation-api 1.0.x
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table vuelo.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "vuelo")
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.countAll", query = "SELECT COUNT(v) FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findByIdVuelo", query = "SELECT v FROM Vuelo v WHERE v.idVuelo = :idVuelo")
    , @NamedQuery(name = "Vuelo.findByNumeroVuelo", query = "SELECT v FROM Vuelo v WHERE v.numeroVuelo = :numeroVuelo")
    , @NamedQuery(name = "Vuelo.findBytipoVuelo", query = "SELECT v FROM Vuelo v WHERE v.tipoVuelo = :tipoVuelo")
    , @NamedQuery(name = "Vuelo.findByestacionOrigen", query = "SELECT v FROM Vuelo v WHERE v.estacionOrigen = :estacionOrigen")
    , @NamedQuery(name = "Vuelo.findByestacionDestino", query = "SELECT v FROM Vuelo v WHERE v.estacionDestino = :estacionDestino")
    , @NamedQuery(name = "Vuelo.findBytipoCabina", query = "SELECT v FROM Vuelo v WHERE v.tipoCabina = :tipoCabina")
    , @NamedQuery(name = "Vuelo.findBycompania", query = "SELECT v FROM Vuelo v WHERE v.compania = :compania")
    , @NamedQuery(name = "Vuelo.findByclase", query = "SELECT v FROM Vuelo v WHERE v.clase = :clase")
    , @NamedQuery(name = "Vuelo.findByEstatus", query = "SELECT v FROM Vuelo v WHERE v.estatus = :estatus")
})
public class Vuelo implements java.io.Serializable {
    private static final long serialVersionUID = 834600351;
    
    /**
    * The 'id vuelo' Maps to COLUMN 'id_vuelo'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_VUELO" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idVuelo;
    
    /**
    * The 'numero vuelo' Maps to COLUMN 'numero_vuelo'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "NUMERO_VUELO" , nullable=false)
    private int numeroVuelo;
    
    /**
    * The 'tipo vuelo' Maps to COLUMN 'tipo_vuelo'
    */
    
    @JoinColumn(name = "TIPO_VUELO" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros tipoVuelo;
    
    /**
    * The 'id estacion origen' Maps to COLUMN 'id_estacion_origen'
    */
    
    @JoinColumn(name = "ID_ESTACION_ORIGEN" , referencedColumnName = "ID_ESTACION")
    @ManyToOne(optional = false)
    private Estacion estacionOrigen;
    
    /**
    * The 'id estacion destino' Maps to COLUMN 'id_estacion_destino'
    */
    
    @JoinColumn(name = "ID_ESTACION_DESTINO" , referencedColumnName = "ID_ESTACION")
    @ManyToOne(optional = false)
    private Estacion estacionDestino;
    
    /**
    * The 'tipo cabina' Maps to COLUMN 'tipo_cabina'
    */
    
    @JoinColumn(name = "TIPO_CABINA" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros tipoCabina;
    
    /**
    * The 'id compania' Maps to COLUMN 'id_compania'
    */
    
    @JoinColumn(name = "ID_COMPANIA" , referencedColumnName = "ID_COMPANIA")
    @ManyToOne(optional = false)
    private Compania compania;
    
    /**
    * The 'id clase' Maps to COLUMN 'id_clase'
    */
    
    @JoinColumn(name = "ID_CLASE" , referencedColumnName = "ID_CLASE")
    @ManyToOne(optional = false)
    private Clase clase;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Vuelo() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdVuelo() { return this.idVuelo;}
    public void setIdVuelo(Integer v) { this.idVuelo = v; }
    
    public int getNumeroVuelo() { return this.numeroVuelo;}
    public void setNumeroVuelo(int v) { this.numeroVuelo = v; }
    
    public Parametros getTipoVuelo(){ return this.tipoVuelo ; }
    public void setTipoVuelo(Parametros x){ this.tipoVuelo = x; }
    
    public Estacion getEstacionOrigen(){ return this.estacionOrigen ; }
    public void setEstacionOrigen(Estacion x){ this.estacionOrigen = x; }
    
    public Estacion getEstacionDestino(){ return this.estacionDestino ; }
    public void setEstacionDestino(Estacion x){ this.estacionDestino = x; }
    
    public Parametros getTipoCabina(){ return this.tipoCabina ; }
    public void setTipoCabina(Parametros x){ this.tipoCabina = x; }
    
    public Compania getCompania(){ return this.compania ; }
    public void setCompania(Compania x){ this.compania = x; }
    
    public Clase getClase(){ return this.clase ; }
    public void setClase(Clase x){ this.clase = x; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idVuelo).hashCode();
		hash += String.valueOf(numeroVuelo).hashCode();
		hash += String.valueOf(tipoVuelo).hashCode();
		hash += String.valueOf(estacionOrigen).hashCode();
		hash += String.valueOf(estacionDestino).hashCode();
		hash += String.valueOf(tipoCabina).hashCode();
		hash += String.valueOf(compania).hashCode();
		hash += String.valueOf(clase).hashCode();
		hash += String.valueOf(estatus).hashCode();
        return hash;
    }

	@Override
    public boolean equals(Object o){
		if (this == o) {
			return true;
	    }
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}        
        if (!(o instanceof Vuelo)) {
            return false;
        }		
		Vuelo other = (Vuelo ) o;
		if (!Objects.equals(this.idVuelo, other.idVuelo)) { return false; }		
		if (!Objects.equals(this.numeroVuelo, other.numeroVuelo)) { return false; }		
		if (!Objects.equals(this.tipoVuelo, other.tipoVuelo)) { return false; }		
		if (!Objects.equals(this.estacionOrigen, other.estacionOrigen)) { return false; }		
		if (!Objects.equals(this.estacionDestino, other.estacionDestino)) { return false; }		
		if (!Objects.equals(this.tipoCabina, other.tipoCabina)) { return false; }		
		if (!Objects.equals(this.compania, other.compania)) { return false; }		
		if (!Objects.equals(this.clase, other.clase)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Vuelo{");
		sb.append("idVuelo" ).append("=").append(idVuelo).append("|");
		sb.append("numeroVuelo" ).append("=").append(numeroVuelo).append("|");
		sb.append("tipoVuelo" ).append("=").append(tipoVuelo).append("|");
		sb.append("estacionOrigen" ).append("=").append(estacionOrigen).append("|");
		sb.append("estacionDestino" ).append("=").append(estacionDestino).append("|");
		sb.append("tipoCabina" ).append("=").append(tipoCabina).append("|");
		sb.append("compania" ).append("=").append(compania).append("|");
		sb.append("clase" ).append("=").append(clase).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
