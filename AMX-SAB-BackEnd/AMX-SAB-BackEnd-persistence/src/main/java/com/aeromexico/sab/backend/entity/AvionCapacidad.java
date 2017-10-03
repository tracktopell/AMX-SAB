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
 * Class for mapping JPA Entity of Table avion_capacidad.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

@Entity
@Table(name = "avion_capacidad")
@NamedQueries({
    @NamedQuery(name = "AvionCapacidad.findAll", query = "SELECT a FROM AvionCapacidad a")
    , @NamedQuery(name = "AvionCapacidad.countAll", query = "SELECT COUNT(a) FROM AvionCapacidad a")
    , @NamedQuery(name = "AvionCapacidad.findByIdAvionCapacidad", query = "SELECT a FROM AvionCapacidad a WHERE a.idAvionCapacidad = :idAvionCapacidad")
    , @NamedQuery(name = "AvionCapacidad.findByavion", query = "SELECT a FROM AvionCapacidad a WHERE a.avion = :avion")
    , @NamedQuery(name = "AvionCapacidad.findByclase", query = "SELECT a FROM AvionCapacidad a WHERE a.clase = :clase")
    , @NamedQuery(name = "AvionCapacidad.findByCapacidad", query = "SELECT a FROM AvionCapacidad a WHERE a.capacidad = :capacidad")
})
public class AvionCapacidad implements java.io.Serializable {
    private static final long serialVersionUID = 1023892928;
    
    /**
    * The 'id avion capacidad' Maps to COLUMN 'id_avion_capacidad'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_AVION_CAPACIDAD" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAvionCapacidad;
    
    /**
    * The 'id avion' Maps to COLUMN 'id_avion'
    */
    
    @JoinColumn(name = "ID_AVION" , referencedColumnName = "ID_AVION")
    @ManyToOne(optional = false)
    private Avion avion;
    
    /**
    * The 'id clase' Maps to COLUMN 'id_clase'
    */
    
    @JoinColumn(name = "ID_CLASE" , referencedColumnName = "ID_CLASE")
    @ManyToOne(optional = false)
    private Clase clase;
    
    /**
    * The 'capacidad' Maps to COLUMN 'capacidad'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "CAPACIDAD" , nullable=false)
    private int capacidad;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public AvionCapacidad() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdAvionCapacidad() { return this.idAvionCapacidad;}
    public void setIdAvionCapacidad(Integer v) { this.idAvionCapacidad = v; }
    
    public Avion getAvion(){ return this.avion ; }
    public void setAvion(Avion x){ this.avion = x; }
    
    public Clase getClase(){ return this.clase ; }
    public void setClase(Clase x){ this.clase = x; }
    
    public int getCapacidad() { return this.capacidad;}
    public void setCapacidad(int v) { this.capacidad = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvionCapacidad).hashCode();
		hash += String.valueOf(avion).hashCode();
		hash += String.valueOf(clase).hashCode();
		hash += String.valueOf(capacidad).hashCode();
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
        if (!(o instanceof AvionCapacidad)) {
            return false;
        }		
		AvionCapacidad other = (AvionCapacidad ) o;
		if (!Objects.equals(this.idAvionCapacidad, other.idAvionCapacidad)) { return false; }		
		if (!Objects.equals(this.avion, other.avion)) { return false; }		
		if (!Objects.equals(this.clase, other.clase)) { return false; }		
		if (!Objects.equals(this.capacidad, other.capacidad)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("AvionCapacidad{");
		sb.append("idAvionCapacidad" ).append("=").append(idAvionCapacidad).append("|");
		sb.append("avion" ).append("=").append(avion).append("|");
		sb.append("clase" ).append("=").append(clase).append("|");
		sb.append("capacidad" ).append("=").append(capacidad).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
