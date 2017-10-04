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
 * Class for mapping JPA Entity of Table ciudad.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

@Entity
@Table(name = "ciudad")
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.countAll", query = "SELECT COUNT(c) FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Ciudad.findBypais", query = "SELECT c FROM Ciudad c WHERE c.pais = :pais")
    , @NamedQuery(name = "Ciudad.findByEstatus", query = "SELECT c FROM Ciudad c WHERE c.estatus = :estatus")
})
public class Ciudad implements java.io.Serializable {
    private static final long serialVersionUID = 1418481495;
    
    /**
    * The 'id ciudad' Maps to COLUMN 'id_ciudad'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_CIUDAD" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCiudad;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "NOMBRE" , length=50, nullable=false)
    private String nombre;
    
    /**
    * The 'id pais' Maps to COLUMN 'id_pais'
    */
    
    @JoinColumn(name = "ID_PAIS" , referencedColumnName = "ID_PAIS")
    @ManyToOne(optional = false)
    private Pais pais;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to estacion table where has id_ciudad object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    // estacion Well know as Estacion
    private List<Estacion> estacionThatHasThisCiudadList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Ciudad() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdCiudad() { return this.idCiudad;}
    public void setIdCiudad(Integer v) { this.idCiudad = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public Pais getPais(){ return this.pais ; }
    public void setPais(Pais x){ this.pais = x; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Estacion> getEstacionThatHasThisCiudadList(){ return this.estacionThatHasThisCiudadList; }
    public void setEstacionThatHasThisCiudadList(List<Estacion> v){ this.estacionThatHasThisCiudadList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idCiudad).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(pais).hashCode();
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
        if (!(o instanceof Ciudad)) {
            return false;
        }		
		Ciudad other = (Ciudad ) o;
		if (!Objects.equals(this.idCiudad, other.idCiudad)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.pais, other.pais)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Ciudad{");
		sb.append("idCiudad" ).append("=").append(idCiudad).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("pais" ).append("=").append(pais).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
