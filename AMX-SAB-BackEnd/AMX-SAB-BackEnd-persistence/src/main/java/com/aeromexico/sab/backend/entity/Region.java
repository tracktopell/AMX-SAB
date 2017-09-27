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
 * Class for mapping JPA Entity of Table region.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

@Entity
@Table(name = "region")
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
    , @NamedQuery(name = "Region.countAll", query = "SELECT COUNT(r) FROM Region r")
    , @NamedQuery(name = "Region.findByIdRegion", query = "SELECT r FROM Region r WHERE r.idRegion = :idRegion")
    , @NamedQuery(name = "Region.findByCveRegion", query = "SELECT r FROM Region r WHERE r.cveRegion = :cveRegion")
    , @NamedQuery(name = "Region.findByNombre", query = "SELECT r FROM Region r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Region.findByEstatus", query = "SELECT r FROM Region r WHERE r.estatus = :estatus")
})
public class Region implements java.io.Serializable {
    private static final long serialVersionUID = 1160460865;
    
    /**
    * The 'id region' Maps to COLUMN 'id_region'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID_REGION" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idRegion;
    
    /**
    * The 'cve region' Maps to COLUMN 'cve_region'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CVE_REGION" , length=3, nullable=false)
    private String cveRegion;
    
    /**
    * The 'nombre' Maps to COLUMN 'nombre'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE" , length=50, nullable=false)
    private String nombre;
    
    /**
    * The 'estatus' Maps to COLUMN 'estatus'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS" , nullable=false)
    private Short estatus;
    /** 
    * Map the relation to horario table where has id_region object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    // horario Well know as Horario
    private List<Horario> horarioThatHasThisRegionList;
    
    /** 
    * Map the relation to pais table where has id_region object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    // pais Well know as Pais
    private List<Pais> paisThatHasThisRegionList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Region() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getIdRegion() { return this.idRegion;}
    public void setIdRegion(Integer v) { this.idRegion = v; }
    
    public String getCveRegion() { return this.cveRegion;}
    public void setCveRegion(String v) { this.cveRegion = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public Short getEstatus() { return this.estatus;}
    public void setEstatus(Short v) { this.estatus = v; }
    
    // O2M <*>    
    public List<Horario> getHorarioThatHasThisRegionList(){ return this.horarioThatHasThisRegionList; }
    public void setHorarioThatHasThisRegionList(List<Horario> v){ this.horarioThatHasThisRegionList = v; }
    
    public List<Pais> getPaisThatHasThisRegionList(){ return this.paisThatHasThisRegionList; }
    public void setPaisThatHasThisRegionList(List<Pais> v){ this.paisThatHasThisRegionList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idRegion).hashCode();
		hash += String.valueOf(cveRegion).hashCode();
		hash += String.valueOf(nombre).hashCode();
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
        if (!(o instanceof Region)) {
            return false;
        }		
		Region other = (Region ) o;
		if (!Objects.equals(this.idRegion, other.idRegion)) { return false; }		
		if (!Objects.equals(this.cveRegion, other.cveRegion)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Region{");
		sb.append("idRegion" ).append("=").append(idRegion).append("|");
		sb.append("cveRegion" ).append("=").append(cveRegion).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("estatus" ).append("=").append(estatus).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
