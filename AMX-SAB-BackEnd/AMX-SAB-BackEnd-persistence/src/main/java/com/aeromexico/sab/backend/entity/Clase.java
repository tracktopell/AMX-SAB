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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table clase.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "clase")
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c")
    , @NamedQuery(name = "Clase.countAll", query = "SELECT COUNT(c) FROM Clase c")
    , @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase")
    , @NamedQuery(name = "Clase.findByNombre", query = "SELECT c FROM Clase c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clase.findByClave", query = "SELECT c FROM Clase c WHERE c.clave = :clave")
    , @NamedQuery(name = "Clase.findByEstatus", query = "SELECT c FROM Clase c WHERE c.estatus = :estatus")
})
public class Clase implements java.io.Serializable {
    private static final long serialVersionUID = 1595428806;
    
    /**
    * The 'id clase' Maps to COLUMN 'id_clase'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_CLASE" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idClase;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE" , length=50, nullable=false)
    private String nombre;
    
    /**
    * The 'clave' Maps to COLUMN 'clave'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CLAVE" , length=10, nullable=false)
    private String clave;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to vuelo table where has id_clase object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase")
    // vuelo Well know as Vuelo
    private List<Vuelo> vueloThatHasThisClaseList;
    
    /** 
    * Map the relation to avion_capacidad table where has id_clase object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase")
    // avion_capacidad Well know as AvionCapacidad
    private List<AvionCapacidad> avionCapacidadThatHasThisClaseList;
    
    /** 
    * Map the relation to avion_audifono table where has id_clase object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase")
    // avion_audifono Well know as AvionAudifono
    private List<AvionAudifono> avionAudifonoThatHasThisClaseList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Clase() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdClase() { return this.idClase;}
    public void setIdClase(Integer v) { this.idClase = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getClave() { return this.clave;}
    public void setClave(String v) { this.clave = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Vuelo> getVueloThatHasThisClaseList(){ return this.vueloThatHasThisClaseList; }
    public void setVueloThatHasThisClaseList(List<Vuelo> v){ this.vueloThatHasThisClaseList = v; }
    
    public List<AvionCapacidad> getAvionCapacidadThatHasThisClaseList(){ return this.avionCapacidadThatHasThisClaseList; }
    public void setAvionCapacidadThatHasThisClaseList(List<AvionCapacidad> v){ this.avionCapacidadThatHasThisClaseList = v; }
    
    public List<AvionAudifono> getAvionAudifonoThatHasThisClaseList(){ return this.avionAudifonoThatHasThisClaseList; }
    public void setAvionAudifonoThatHasThisClaseList(List<AvionAudifono> v){ this.avionAudifonoThatHasThisClaseList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idClase).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(clave).hashCode();
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
        if (!(o instanceof Clase)) {
            return false;
        }		
		Clase other = (Clase ) o;
		if (!Objects.equals(this.idClase, other.idClase)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Clase{");
		sb.append("idClase" ).append("=").append(idClase).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("clave" ).append("=").append(clave).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
