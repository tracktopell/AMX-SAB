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
 * Class for mapping JPA Entity of Table pais.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

@Entity
@Table(name = "pais")
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
    , @NamedQuery(name = "Pais.countAll", query = "SELECT COUNT(p) FROM Pais p")
    , @NamedQuery(name = "Pais.findByIdPais", query = "SELECT p FROM Pais p WHERE p.idPais = :idPais")
    , @NamedQuery(name = "Pais.findByCvePais", query = "SELECT p FROM Pais p WHERE p.cvePais = :cvePais")
    , @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pais.findByregion", query = "SELECT p FROM Pais p WHERE p.region = :region")
    , @NamedQuery(name = "Pais.findByEstatus", query = "SELECT p FROM Pais p WHERE p.estatus = :estatus")
})
public class Pais implements java.io.Serializable {
    private static final long serialVersionUID = 1324119927;
    
    /**
    * The 'id pais' Maps to COLUMN 'id_pais'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID_PAIS" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPais;
    
    /**
    * The 'cve pais' Maps to COLUMN 'cve_pais'
    */
    
    @Basic(optional = true)
    //@Size(max = 3)
    @Column(name = "CVE_PAIS" , length=3, nullable=true)
    private String cvePais;
    
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
    * The 'id region' Maps to COLUMN 'id_region'
    */
    
    @JoinColumn(name = "ID_REGION" , referencedColumnName = "ID_REGION")
    @ManyToOne(optional = false)
    private Region region;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to ciudad table where has id_pais object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    // ciudad Well know as Ciudad
    private List<Ciudad> ciudadThatHasThisPaisList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Pais() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdPais() { return this.idPais;}
    public void setIdPais(Integer v) { this.idPais = v; }
    
    public String getCvePais() { return this.cvePais;}
    public void setCvePais(String v) { this.cvePais = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public Region getRegion(){ return this.region ; }
    public void setRegion(Region x){ this.region = x; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Ciudad> getCiudadThatHasThisPaisList(){ return this.ciudadThatHasThisPaisList; }
    public void setCiudadThatHasThisPaisList(List<Ciudad> v){ this.ciudadThatHasThisPaisList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idPais).hashCode();
		hash += String.valueOf(cvePais).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(region).hashCode();
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
        if (!(o instanceof Pais)) {
            return false;
        }		
		Pais other = (Pais ) o;
		if (!Objects.equals(this.idPais, other.idPais)) { return false; }		
		if (!Objects.equals(this.cvePais, other.cvePais)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.region, other.region)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Pais{");
		sb.append("idPais" ).append("=").append(idPais).append("|");
		sb.append("cvePais" ).append("=").append(cvePais).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("region" ).append("=").append(region).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
