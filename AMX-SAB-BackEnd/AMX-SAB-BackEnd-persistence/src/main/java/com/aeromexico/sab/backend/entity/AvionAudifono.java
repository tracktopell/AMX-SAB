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
 * Class for mapping JPA Entity of Table avion_audifono.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

@Entity
@Table(name = "avion_audifono")
@NamedQueries({
    @NamedQuery(name = "AvionAudifono.findAll", query = "SELECT a FROM AvionAudifono a")
    , @NamedQuery(name = "AvionAudifono.countAll", query = "SELECT COUNT(a) FROM AvionAudifono a")
    , @NamedQuery(name = "AvionAudifono.findByIdAvionAudifono", query = "SELECT a FROM AvionAudifono a WHERE a.idAvionAudifono = :idAvionAudifono")
    , @NamedQuery(name = "AvionAudifono.findByavion", query = "SELECT a FROM AvionAudifono a WHERE a.avion = :avion")
    , @NamedQuery(name = "AvionAudifono.findByclase", query = "SELECT a FROM AvionAudifono a WHERE a.clase = :clase")
    , @NamedQuery(name = "AvionAudifono.findBytipoAudifono", query = "SELECT a FROM AvionAudifono a WHERE a.tipoAudifono = :tipoAudifono")
})
public class AvionAudifono implements java.io.Serializable {
    private static final long serialVersionUID = 1607521710;
    
    /**
    * The 'id avion audifono' Maps to COLUMN 'id_avion_audifono'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_AVION_AUDIFONO" , nullable=false  )
    private Integer idAvionAudifono;
    
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
    * The 'tipo audifono' Maps to COLUMN 'tipo_audifono'
    */
    
    @JoinColumn(name = "TIPO_AUDIFONO" , referencedColumnName = "ID_PARAMETRO")
    @ManyToOne(optional = false)
    private Parametros tipoAudifono;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public AvionAudifono() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdAvionAudifono() { return this.idAvionAudifono;}
    public void setIdAvionAudifono(Integer v) { this.idAvionAudifono = v; }
    
    public Avion getAvion(){ return this.avion ; }
    public void setAvion(Avion x){ this.avion = x; }
    
    public Clase getClase(){ return this.clase ; }
    public void setClase(Clase x){ this.clase = x; }
    
    public Parametros getTipoAudifono(){ return this.tipoAudifono ; }
    public void setTipoAudifono(Parametros x){ this.tipoAudifono = x; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvionAudifono).hashCode();
		hash += String.valueOf(avion).hashCode();
		hash += String.valueOf(clase).hashCode();
		hash += String.valueOf(tipoAudifono).hashCode();
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
        if (!(o instanceof AvionAudifono)) {
            return false;
        }		
		AvionAudifono other = (AvionAudifono ) o;
		if (!Objects.equals(this.idAvionAudifono, other.idAvionAudifono)) { return false; }		
		if (!Objects.equals(this.avion, other.avion)) { return false; }		
		if (!Objects.equals(this.clase, other.clase)) { return false; }		
		if (!Objects.equals(this.tipoAudifono, other.tipoAudifono)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("AvionAudifono{");
		sb.append("idAvionAudifono" ).append("=").append(idAvionAudifono).append("|");
		sb.append("avion" ).append("=").append(avion).append("|");
		sb.append("clase" ).append("=").append(clase).append("|");
		sb.append("tipoAudifono" ).append("=").append(tipoAudifono).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
